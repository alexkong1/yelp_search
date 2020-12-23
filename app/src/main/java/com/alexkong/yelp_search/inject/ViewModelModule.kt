package com.alexkong.yelp_search.inject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.alexkong.yelp_search.SearchViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * This Module binds instances of the ViewModels & ViewModelFactory allowing us to use them properly on the
 * Activities/Fragments that will use them
 */
@Suppress("unused")
@Module
abstract class ViewModelModule {
    // Add the binding for any created ViewModel as shown below
    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindMainActivityViewModel(searchViewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
