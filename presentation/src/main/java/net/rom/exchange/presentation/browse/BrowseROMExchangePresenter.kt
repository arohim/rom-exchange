package net.rom.exchange.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import net.rom.exchange.domain.interactor.SingleUseCase
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.presentation.mapper.ROMExchangeItemMapper
import javax.inject.Inject

class BrowseROMExchangePresenter @Inject constructor(val browseView: BrowseROMExchangeContract.View,
                                                     val getROMEXchangeUseCase: SingleUseCase<List<Item>, ROMExchangeRequest>,
                                                     val bufferooMapper: ROMExchangeItemMapper) :
        BrowseROMExchangeContract.Presenter {

    init {
        browseView.setPresenter(this)
    }

    override fun start() {
        retrieveROMExchangeItems()
    }

    override fun stop() {
        getROMEXchangeUseCase.dispose()
    }

    override fun retrieveROMExchangeItems() {
        getROMEXchangeUseCase.execute(
                singleObserver = ROMExchangeSubscriber(),
                params = ROMExchangeRequest(
                        kw = "",
                        exact = false,
                        sort = Sort.CHANGE,
                        sortDir = SortDir.DESC,
                        sortServer = SortServer.BOTH,
                        sortRange = SortRange.ALL,
                        type = Type.All,
                        page = 1
                )
        )
    }

    internal fun handleGetROMExchangeItemsSuccess(items: List<Item>) {
        browseView.hideErrorState()
        if (items.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showROMExchangeItems(items.map { bufferooMapper.mapToView(it) })
        } else {
            browseView.hideItems()
            browseView.showEmptyState()
        }
    }

    inner class ROMExchangeSubscriber : DisposableSingleObserver<List<Item>>() {
        override fun onSuccess(t: List<Item>) {
            handleGetROMExchangeItemsSuccess(t)
        }

        override fun onError(e: Throwable) {
            browseView.hideItems()
            browseView.hideEmptyState()
            browseView.showErrorState()
        }
    }

}