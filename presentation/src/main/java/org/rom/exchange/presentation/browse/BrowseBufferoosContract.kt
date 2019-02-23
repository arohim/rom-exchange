package org.rom.exchange.presentation.browse

import org.rom.exchange.presentation.BasePresenter
import org.rom.exchange.presentation.BaseView
import org.rom.exchange.presentation.model.BufferooView

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