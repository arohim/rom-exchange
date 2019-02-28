package net.rom.exchange.presentation.browse

import net.rom.exchange.domain.model.rom.ItemExchangeRequest
import net.rom.exchange.presentation.BasePresenter
import net.rom.exchange.presentation.BaseView
import net.rom.exchange.presentation.model.ItemExchangeView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface BrowseItemExchangeContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showItemExchange(itemExchange: List<ItemExchangeView>)

        fun hideItems()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {
        var currentPage: Int

        var itemExchangeRequest: ItemExchangeRequest?

        var isLoading: Boolean

        fun retrieveItemExchange()

        fun searchKeyword(keyword: String)

        fun listScrolled(visibleItemCount: Int, lastVisibleItem: Int, totalItemCount: Int)

    }

}