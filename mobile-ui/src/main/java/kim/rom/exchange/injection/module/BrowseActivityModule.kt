package kim.rom.exchange.injection.module

import dagger.Module
import dagger.Provides
import kim.rom.exchange.browse.BrowseActivity
import kim.rom.exchange.domain.interactor.browse.ROMExchange
import kim.rom.exchange.injection.scopes.PerActivity
import kim.rom.exchange.presentation.browse.BrowseROMExchangeContract
import kim.rom.exchange.presentation.browse.BrowseROMExchangePresenter
import kim.rom.exchange.presentation.mapper.ROMExchangeItemMapper


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseROMExchangeContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseROMExchangeContract.View,
                                        romExchange: ROMExchange, mapper: ROMExchangeItemMapper):
            BrowseROMExchangeContract.Presenter {
        return BrowseROMExchangePresenter(mainView, romExchange, mapper)
    }

}
