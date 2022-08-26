package com.br.cartola.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.cartola.model.LigasModel
import com.br.cartola.repository.RepositotyCartola
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LigasCartolaViewModel(
    private val repository: RepositotyCartola
) : ViewModel() {

    private val _toastText = MutableLiveData<String?>()
    val toastText: LiveData<String?>
        get() = _toastText

    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean>
        get() = _spinner

    private val _ligas = MutableLiveData<LigasModel>()
    val ligas: LiveData<LigasModel>
        get() = _ligas

    fun getMinhasLigasApi(token: String?) {
//        launchDataLoad {
        viewModelScope.launch {
            val getList = repository.getMinhasLigasApi(token)
            _ligas.postValue(getList!!)
        }

//        }
       // return _ligas.value
    }

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _spinner.value = true
                block()
            } catch (error: java.lang.Exception) {
                _toastText.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }
}