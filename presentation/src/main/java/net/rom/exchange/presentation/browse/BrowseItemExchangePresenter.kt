package net.rom.exchange.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import net.rom.exchange.domain.interactor.SingleUseCase
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.presentation.mapper.ItemExchangeMapper
import javax.inject.Inject

class BrowseItemExchangePresenter @Inject constructor(val browseView: BrowseItemExchangeContract.View,
                                                      val getItemEXchangeUseCase: SingleUseCase<List<ItemExchange>, ItemExchangeRequest>,
                                                      val bufferooMapper: ItemExchangeMapper) :
        BrowseItemExchangeContract.Presenter {

    companion object {
        private const val VISIBLE_THRESHOLD = 5
    }

    override var currentPage: Int = 1

    override var itemExchangeRequest: ItemExchangeRequest? = null

    init {
        browseView.setPresenter(this)
    }

    override fun start() {
        retrieveItemExchange()
    }

    override fun stop() {
        getItemEXchangeUseCase.dispose()
    }

    override fun retrieveItemExchange() {
        browseView.showProgress()
        getItemEXchangeUseCase.execute(singleObserver = ItemExchangeSubscriber(), params = getRequest())
    }

    private fun getRequest(): ItemExchangeRequest? {
        if (itemExchangeRequest == null) {
            itemExchangeRequest = makeDefaultRequest()
        }

        return itemExchangeRequest
    }

    private fun makeDefaultRequest(): ItemExchangeRequest {
        return ItemExchangeRequest(
                kw = "",
                exact = false,
                sort = Sort.CHANGE,
                sortDir = SortDir.DESC,
                sortServer = SortServer.BOTH,
                sortRange = SortRange.ALL,
                type = Type.All,
                page = 1
        )
    }

    internal fun handleGetROMExchangeItemsSuccess(items: List<ItemExchange>) {
        browseView.hideErrorState()
        if (items.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showItemExchange(items.map { bufferooMapper.mapToView(it) })
        } else {
            browseView.hideItems()
            browseView.showEmptyState()
        }
    }

    override fun searchKeyword(keyword: String) {
        itemExchangeRequest?.kw = keyword
        retrieveItemExchange()
    }

    override fun listScrolled(visibleItemCount: Int, lastVisibleItem: Int, totalItemCount: Int) {
        if (visibleItemCount + lastVisibleItem + VISIBLE_THRESHOLD >= totalItemCount) {
            currentPage++
            itemExchangeRequest?.page = currentPage
            retrieveItemExchange()
        }
    }

    inner class ItemExchangeSubscriber : DisposableSingleObserver<List<ItemExchange>>() {
        override fun onSuccess(t: List<ItemExchange>) {
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