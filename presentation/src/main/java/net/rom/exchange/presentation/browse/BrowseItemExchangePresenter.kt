package net.rom.exchange.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import net.rom.exchange.domain.interactor.SingleUseCase
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.presentation.mapper.rom.ItemExchangeMapper
import javax.inject.Inject

class BrowseItemExchangePresenter @Inject constructor(val browseView: BrowseItemExchangeContract.View,
                                                      val getItemEXchangeUseCase: SingleUseCase<List<ItemExchange>, ItemExchangeRequest>,
                                                      val itemExchangeMapper: ItemExchangeMapper) :
        BrowseItemExchangeContract.Presenter {
    companion object {

        private const val VISIBLE_THRESHOLD = 5
    }

    override var currentItemTitle: String? = null

    override var isLoading: Boolean = false

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
        isLoading = true
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
                type = getItemType(currentItemTitle),
                page = 1
        )
    }

    private fun getItemType(currentItemTitle: String?): Type {
        return Type.values().find { it.itemName == currentItemTitle } ?: Type.All
    }

    internal fun handleGetROMExchangeItemsSuccess(items: List<ItemExchange>) {
        browseView.hideErrorState()
        if (items.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showItemExchange(items.map { itemExchangeMapper.mapToView(it) })
        } else {
            browseView.hideItems()
            browseView.showEmptyState()
        }
    }

    override fun searchKeyword(keyword: String) {
        itemExchangeRequest?.kw = keyword
        itemExchangeRequest?.page = 1
        itemExchangeRequest?.type = Type.All
        browseView.resetItemExchange()
        retrieveItemExchange()
    }

    override fun listScrolled(visibleItemCount: Int, lastVisibleItem: Int, totalItemCount: Int) {
        val displayedItems = visibleItemCount + lastVisibleItem + VISIBLE_THRESHOLD
        if (shouldLoadMore(displayedItems, totalItemCount) && !isLoading) {
            currentPage++
            itemExchangeRequest?.page = currentPage
            retrieveItemExchange()
        }
    }

    private fun shouldLoadMore(displayedItems: Int, totalItemCount: Int) = displayedItems >= totalItemCount

    inner class ItemExchangeSubscriber : DisposableSingleObserver<List<ItemExchange>>() {
        override fun onSuccess(t: List<ItemExchange>) {
            isLoading = false
            browseView.hideProgress()
            handleGetROMExchangeItemsSuccess(t)
        }

        override fun onError(e: Throwable) {
            isLoading = false
            browseView.hideProgress()
            browseView.hideItems()
            browseView.hideEmptyState()
            browseView.showErrorState()
        }
    }

}