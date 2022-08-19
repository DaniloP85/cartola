package com.br.cartola.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.cartola.model.LigaModel
import com.br.cartola.model.TimesModel
import com.br.cartola.repository.RepositotyCartola
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class TimesCartolaViewModel(
    private val repository: RepositotyCartola
) : ViewModel() {

    private val _toastText = MutableLiveData<String?>()
    val toastText: LiveData<String?>
        get() = _toastText

    private val _spinner = MutableLiveData<Boolean>()
    val spinner: LiveData<Boolean>
        get() = _spinner

    private val _times = MutableLiveData<TimesModel>()
    val times: LiveData<TimesModel>
        get() = _times

    fun getTimesApi(token: String?): TimesModel? {
        launchDataLoad {
            _times.value = repository.getTimesApi(token)
        }
        return _times.value
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