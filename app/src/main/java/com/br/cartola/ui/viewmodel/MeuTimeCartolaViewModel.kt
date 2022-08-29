package com.br.cartola.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.cartola.model.MeuTimeModel
import com.br.cartola.repository.RepositotyCartola
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class MeuTimeCartolaViewModel(
    private val repository: RepositotyCartola
) : ViewModel() {

    private val _toastText = MutableLiveData<String?>()
    val toastText: LiveData<String?>
        get() = _toastText

    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean>
        get() = _spinner

    private val _meuTime = MutableLiveData<MeuTimeModel>()
    val meuTime: LiveData<MeuTimeModel>
        get() = _meuTime

    fun getMeuTimeApi(token: String?) {
        viewModelScope.launch {
            val getMeuTime = repository.getMeuTimeApi(token)
            _meuTime.postValue(getMeuTime!!)
        }
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