package org.rom.exchange.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import org.rom.exchange.browse.BrowseActivity

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<BrowseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()

}