package org.rom.exchange.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import org.rom.exchange.browse.BrowseActivity
import org.rom.exchange.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}