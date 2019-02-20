package kim.rom.exchange.presentation.browse

import kim.rom.exchange.presentation.BasePresenter
import kim.rom.exchange.presentation.BaseView
import kim.rom.exchange.presentation.model.BufferooView
import kim.rom.exchange.presentation.model.ROMExchangeItemView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface BrowseROMExchangeContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showROMExchangeItems(romExchangeItems: List<ROMExchangeItemView>)

        fun hideItems()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveROMExchangeItems()

    }

}