package com.br.cartola.di

import com.br.cartola.repository.RepositotyCartola
import com.br.cartola.retrofit.webclient.WebClientCartola
import com.br.cartola.ui.viewmodel.TimesCartolaViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val webClientModule = module {
    single<WebClientCartola> { WebClientCartola() }
}

val daoModule = module {
    single<RepositotyCartola> { RepositotyCartola(get()) }
}

val viewModelModule = module {
    viewModel<TimesCartolaViewModel> { TimesCartolaViewModel(get()) }
}