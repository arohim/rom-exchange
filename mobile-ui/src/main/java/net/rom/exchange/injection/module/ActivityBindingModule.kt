package net.rom.exchange.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.rom.exchange.browse.BrowseActivity
import net.rom.exchange.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}