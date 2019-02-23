package net.rom.exchange.injection.module

import dagger.Module
import dagger.Provides
import net.rom.exchange.browse.BrowseFragment
import net.rom.exchange.domain.interactor.browse.ROMExchange
import net.rom.exchange.injection.scopes.PerActivity
import net.rom.exchange.presentation.browse.BrowseROMExchangeContract
import net.rom.exchange.presentation.browse.BrowseROMExchangePresenter
import net.rom.exchange.presentation.mapper.ROMExchangeItemMapper


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseFragmentModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseFragment: BrowseFragment): BrowseROMExchangeContract.View {
        return browseFragment
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseROMExchangeContract.View,
                                        romExchange: ROMExchange, mapper: ROMExchangeItemMapper):
            BrowseROMExchangeContract.Presenter {
        return BrowseROMExchangePresenter(mainView, romExchange, mapper)
    }

}
