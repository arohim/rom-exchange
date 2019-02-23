package net.rom.exchange.presentation.browse

import net.rom.exchange.presentation.BasePresenter
import net.rom.exchange.presentation.BaseView
import net.rom.exchange.presentation.model.ROMExchangeItemView

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