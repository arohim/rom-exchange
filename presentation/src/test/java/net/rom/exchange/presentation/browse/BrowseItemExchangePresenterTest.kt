package net.rom.exchange.presentation.browse

import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableSingleObserver
import net.rom.exchange.domain.interactor.browse.GetItemExchange
import net.rom.exchange.domain.model.rom.*
import net.rom.exchange.presentation.factory.BufferooFactory
import net.rom.exchange.presentation.factory.ItemExchangeFactory
import net.rom.exchange.presentation.mapper.ItemExchangeMapper
import org.junit.Assert.assertEquals
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
    private lateinit var requestCaptor: KArgumentCaptor<ItemExchangeRequest>

    @Before
    fun setup() {
        captor = argumentCaptor()
        requestCaptor = argumentCaptor()
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
        browseItemExchangePresenter.itemExchangeRequest = ItemExchangeRequest(
                kw = "",
                exact = false,
                sort = Sort.CHANGE,
                sortDir = SortDir.DESC,
                sortServer = SortServer.BOTH,
                sortRange = SortRange.ALL,
                type = Type.All,
                page = 1
        )

        // WHEN
        browseItemExchangePresenter.searchKeyword(keyword)

        // THEN
        verify(mockGetItemExchange).execute(captor.capture(), requestCaptor.capture())
        captor.firstValue.onSuccess(itemExchange)
        val request = requestCaptor.firstValue
        assertEquals(keyword, request.kw)
        verify(mockBrowseItemExchangeView).showItemExchange(itemExchange.map { mockItemExchangeMapper.mapToView(it) })
    }

    @Test
    fun `Page 2 retrieve`() {
        // GIVEN
        val itemExchange = ItemExchangeFactory.makeItemExchangeList(2)
        browseItemExchangePresenter.currentPage = 1
        browseItemExchangePresenter.itemExchangeRequest = ItemExchangeRequest(
                kw = "",
                exact = false,
                sort = Sort.CHANGE,
                sortDir = SortDir.DESC,
                sortServer = SortServer.BOTH,
                sortRange = SortRange.ALL,
                type = Type.All,
                page = 1
        )

        val visibleItemCount = 7
        val lastVisibleItem = 3
        val totalItemCount = 10

        // WHEN
        // if (visibleItemCount + lastVisibleItem + VISIBLE_THRESHOLD >= totalItemCount) {
        browseItemExchangePresenter.listScrolled(visibleItemCount, lastVisibleItem, totalItemCount)

        // THEN
        verify(mockGetItemExchange).execute(captor.capture(), requestCaptor.capture())
        captor.firstValue.onSuccess(itemExchange)
        val request = requestCaptor.firstValue
        assertEquals(2, request.page)
        verify(mockBrowseItemExchangeView).showItemExchange(itemExchange.map { mockItemExchangeMapper.mapToView(it) })
    }
    //</editor-fold>

}