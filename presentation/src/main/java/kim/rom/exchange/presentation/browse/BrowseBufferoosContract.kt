package kim.rom.exchange.presentation.browse

import kim.rom.exchange.presentation.BasePresenter
import kim.rom.exchange.presentation.BaseView
import kim.rom.exchange.presentation.model.BufferooView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface BrowseBufferoosContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showBufferoos(bufferoos: List<BufferooView>)

        fun hideBufferoos()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrieveBufferoos()

    }

}