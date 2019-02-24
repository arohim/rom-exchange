package net.rom.exchange.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import net.rom.exchange.domain.interactor.SingleUseCase
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.presentation.mapper.ItemExchangeMapper
import javax.inject.Inject

class BrowseItemExchangePresenter @Inject constructor(val browseView: BrowseItemExchangeContract.View,
                                                      val getROMEXchangeUseCase: SingleUseCase<List<Item>, ItemExchangeRequest>,
                                                      val bufferooMapper: ItemExchangeMapper) :
        BrowseItemExchangeContract.Presenter {

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
        browseView.showProgress()
        getROMEXchangeUseCase.execute(
                singleObserver = ROMExchangeSubscriber(),
                params = ItemExchangeRequest(
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
            browseView.showItemExchange(items.map { bufferooMapper.mapToView(it) })
        } else {
            browseView.hideItems()
            browseView.showEmptyState()
        }
    }

    inner class ROMExchangeSubscriber : DisposableSingleObserver<List<Item>>() {
        override fun onSuccess(t: List<Item>) {
            browseView.hideProgress()
            handleGetROMExchangeItemsSuccess(t)
        }

        override fun onError(e: Throwable) {
            browseView.hideProgress()
            browseView.hideItems()
            browseView.hideEmptyState()
            browseView.showErrorState()
        }
    }

}