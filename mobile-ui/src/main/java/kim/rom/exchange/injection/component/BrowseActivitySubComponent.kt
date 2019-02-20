package kim.rom.exchange.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import kim.rom.exchange.browse.BrowseActivity

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<BrowseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()

}