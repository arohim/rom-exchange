package net.rom.exchange.injection.module

import dagger.Module
import dagger.Provides
import net.rom.exchange.browse.BrowseFragment
import net.rom.exchange.domain.interactor.browse.GetItemExchange
import net.rom.exchange.injection.scopes.PerActivity
import net.rom.exchange.presentation.browse.BrowseItemExchangeContract
import net.rom.exchange.presentation.browse.BrowseItemExchangePresenter
import net.rom.exchange.presentation.mapper.rom.ItemExchangeMapper


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseFragmentModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseFragment: BrowseFragment): BrowseItemExchangeContract.View {
        return browseFragment
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseItemExchangeContract.View,
                                        itemExchange: GetItemExchange, mapper: ItemExchangeMapper):
            BrowseItemExchangeContract.Presenter {
        return BrowseItemExchangePresenter(mainView, itemExchange, mapper)
    }

}
