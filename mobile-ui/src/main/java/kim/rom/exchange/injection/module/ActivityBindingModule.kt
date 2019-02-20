package kim.rom.exchange.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kim.rom.exchange.browse.BrowseActivity
import kim.rom.exchange.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}