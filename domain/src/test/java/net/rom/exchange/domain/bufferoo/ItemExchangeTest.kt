package net.rom.exchange.domain.bufferoo

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import net.rom.exchange.domain.executor.PostExecutionThread
import net.rom.exchange.domain.executor.ThreadExecutor
import net.rom.exchange.domain.factory.ItemExchangeFactory
import net.rom.exchange.domain.interactor.browse.GetItemExchange
import net.rom.exchange.domain.model.rom.ItemExchange
import net.rom.exchange.domain.repository.ItemExchangeRepository
import org.junit.Before
import org.junit.Test

class ItemExchangeTest {

    private lateinit var getItemExchange: GetItemExchange

    private lateinit var mockThreadExecutor: ThreadExecutor
    private lateinit var mockPostExecutionThread: PostExecutionThread
    private lateinit var mockItemExchangeRepository: ItemExchangeRepository

    @Before
    fun setUp() {
        mockThreadExecutor = mock()
        mockPostExecutionThread = mock()
        mockItemExchangeRepository = mock()
        getItemExchange = GetItemExchange(mockItemExchangeRepository, mockThreadExecutor,
                mockPostExecutionThread)
    }

    @Test
    fun buildUseCaseObservableCallsRepository() {
        // GIVEN

        // WHEN
        getItemExchange.buildUseCaseObservable(null)

        // THEN
        verify(mockItemExchangeRepository).getItems(any(), any(), any(), any(), any(), any(), any()
                , any())
    }

    @Test
    fun buildUseCaseObservableCompletes() {
        // GIVEN
        stubItemExchangeRepositoryGetItem(Single.just(ItemExchangeFactory.makeItemList(2)))

        // WHEN
        val testObserver = getItemExchange.buildUseCaseObservable(null).test()

        // THEN
        testObserver.assertComplete()
    }

    @Test
    fun buildUseCaseObservableReturnsData() {
        // GIVEN
        val itemExchange = ItemExchangeFactory.makeItemList(2)
        stubItemExchangeRepositoryGetItem(Single.just(itemExchange))

        // WHEN
        val testObserver = getItemExchange.buildUseCaseObservable(null).test()
        
        // THEN
        testObserver.assertValue(itemExchange)
    }

    private fun stubItemExchangeRepositoryGetItem(single: Single<List<ItemExchange>>) {
        whenever(mockItemExchangeRepository.getItems(any(), any(), any(), any(), any(), any(), any()
                , any())).thenReturn(single)
    }

}