package com.br.cartola.ui.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.br.cartola.repository.RepositotyCartola
import com.br.cartola.ui.viewmodel.MeuTimeCartolaViewModel

class MeuTimeCartolaViewModelFactory(
    private val repositotyCartola: RepositotyCartola
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MeuTimeCartolaViewModel(repositotyCartola) as T
    }


}