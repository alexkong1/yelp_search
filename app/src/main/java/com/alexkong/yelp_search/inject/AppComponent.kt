package com.alexkong.yelp_search.inject

import com.alexkong.yelp_search.YelpApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector

@AppScope
@Component(modules = [ApiModule::class])
interface AppComponent: AndroidInjector<YelpApplication> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: YelpApplication): Builder
        fun build(): AppComponent
    }
}