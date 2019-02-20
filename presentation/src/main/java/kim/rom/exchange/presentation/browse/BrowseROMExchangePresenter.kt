package kim.rom.exchange.presentation.browse

import io.reactivex.observers.DisposableSingleObserver
import kim.rom.exchange.domain.interactor.SingleUseCase
import kim.rom.exchange.domain.interactor.browse.ROMExchangeRequest
import kim.rom.exchange.domain.model.rom.Item
import kim.rom.exchange.presentation.mapper.ROMExchangeItemMapper
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
                        sort = "change",
                        sortDir = "desc",
                        sortServer = "both",
                        sortRange = "all",
                        type = 0,
                        page = 1
                )
        )
    }

    internal fun handleGetROMExchangeItemsSuccess(items: List<Item>) {
        browseView.hideErrorState()
        if (items.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showBufferoos(items.map { bufferooMapper.mapToView(it) })
        } else {
            browseView.hideBufferoos()
            browseView.showEmptyState()
        }
    }

    inner class ROMExchangeSubscriber : DisposableSingleObserver<List<Item>>() {
        override fun onSuccess(t: List<Item>) {
            handleGetROMExchangeItemsSuccess(t)
        }

        override fun onError(e: Throwable) {
            browseView.hideBufferoos()
            browseView.hideEmptyState()
            browseView.showErrorState()
        }
    }

}