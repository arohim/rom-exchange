package net.rom.exchange.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import net.rom.exchange.browse.BrowseFragment

@Subcomponent
interface BrowseFragmentSubComponent : AndroidInjector<BrowseFragment> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseFragment>()

}