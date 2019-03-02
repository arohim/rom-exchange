package net.rom.exchange.injection.module

import dagger.Module
import dagger.Provides
import net.rom.exchange.browse.BrowseActivity
import net.rom.exchange.domain.interactor.browse.GetItemExchange
import net.rom.exchange.injection.scopes.PerActivity
import net.rom.exchange.presentation.browse.BrowseItemExchangeContract
import net.rom.exchange.presentation.browse.BrowseItemExchangePresenter
import net.rom.exchange.presentation.mapper.rom.ItemExchangeMapper


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseItemExchangeContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseItemExchangeContract.View,
                                        itemExchange: GetItemExchange, mapper: ItemExchangeMapper):
            BrowseItemExchangeContract.Presenter {
        return BrowseItemExchangePresenter(mainView, itemExchange, mapper)
    }

}
