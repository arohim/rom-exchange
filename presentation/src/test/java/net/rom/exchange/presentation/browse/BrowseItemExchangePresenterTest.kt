package net.rom.exchange.presentation.browse

import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableSingleObserver
import net.rom.exchange.domain.interactor.browse.GetItemExchange
import net.rom.exchange.domain.model.rom.ItemExchange
import net.rom.exchange.presentation.factory.BufferooFactory
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.ItemExchangeMapper
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class BrowseItemExchangePresenterTest {

    private lateinit var mockBrowseItemExchangeView: BrowseItemExchangeContract.View
    private lateinit var mockItemExchangeMapper: ItemExchangeMapper
    private lateinit var mockGetItemExchange: GetItemExchange

    private lateinit var browseItemExchangePresenter: BrowseItemExchangePresenter
    private lateinit var captor: KArgumentCaptor<DisposableSingleObserver<List<ItemExchange>>>

    @Before
    fun setup() {
        captor = argumentCaptor()
        mockBrowseItemExchangeView = mock()
        mockItemExchangeMapper = mock()
        mockGetItemExchange = mock()
        browseItemExchangePresenter = BrowseItemExchangePresenter(mockBrowseItemExchangeView, mockGetItemExchange, mockItemExchangeMapper)
    }

    //<editor-fold desc="Retrieve ItemExchange">
    @Test
    fun retrieveItemExchangeHidesErrorState() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onSuccess(ItemExchangeFactory.makeItemExchangeList(2))
        verify(mockBrowseItemExchangeView).hideErrorState()
    }

    @Test
    fun retrieveItemExchangeHidesEmptyState() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onSuccess(ItemExchangeFactory.makeItemExchangeList(2))
        verify(mockBrowseItemExchangeView).hideEmptyState()
    }

    @Test
    fun retrieveItemExchangeShowsItemExchange() {
        val itemExchange = ItemExchangeFactory.makeItemExchangeList(2)
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onSuccess(itemExchange)
        verify(mockBrowseItemExchangeView).showItemExchange(itemExchange.map { mockItemExchangeMapper.mapToView(it) })
    }

    @Test
    fun retrieveItemExchangeShowsEmptyState() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onSuccess(ItemExchangeFactory.makeItemExchangeList(0))
        verify(mockBrowseItemExchangeView).showEmptyState()
    }

    @Test
    fun retrieveItemExchangeHidesItemExchange() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onSuccess(ItemExchangeFactory.makeItemExchangeList(0))
        verify(mockBrowseItemExchangeView).hideItems()
    }

    @Test
    fun retrieveItemExchangeShowsErrorState() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onError(RuntimeException())
        verify(mockBrowseItemExchangeView).showErrorState()
    }

    @Test
    fun retrieveItemExchangeHidesItemExchangeWhenErrorThrown() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onError(RuntimeException())
        verify(mockBrowseItemExchangeView).hideItems()
    }

    @Test
    fun retrieveItemExchangeHidesEmptyStateWhenErrorThrown() {
        browseItemExchangePresenter.retrieveItemExchange()

        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onError(RuntimeException())
        verify(mockBrowseItemExchangeView).hideEmptyState()
    }

    @Test
    fun retrieveWithKeywordShowsItemExchange() {
        // GIVEN
        val itemExchange = ItemExchangeFactory.makeItemExchangeList(2)
        val keyword = "keyword"

        // WHEN
        browseItemExchangePresenter.searchKeyword(keyword)

        // THEN
        verify(mockGetItemExchange).execute(captor.capture(), any())
        captor.firstValue.onSuccess(itemExchange)
        verify(mockBrowseItemExchangeView).showItemExchange(itemExchange.map { mockItemExchangeMapper.mapToView(it) })
    }
    //</editor-fold>

}