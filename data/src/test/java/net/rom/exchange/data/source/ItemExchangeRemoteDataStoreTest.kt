package net.rom.exchange.data.source

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import net.rom.exchange.data.factory.BufferooFactory
import net.rom.exchange.data.factory.DataFactory.Factory.randomBoolean
import net.rom.exchange.data.factory.DataFactory.Factory.randomInt
import net.rom.exchange.data.factory.DataFactory.Factory.randomUuid
import net.rom.exchange.data.factory.ItemExchangeFactory
import net.rom.exchange.data.model.rom.ItemEntity
import net.rom.exchange.data.repository.ItemExchangeRemote
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemExchangeRemoteDataStoreTest {

    private lateinit var itemExchangeRemoteDataStore: ItemExchangeRemoteDataStore

    private lateinit var itemExchangeRemote: ItemExchangeRemote

    @Before
    fun setUp() {
        itemExchangeRemote = mock()
        itemExchangeRemoteDataStore = ItemExchangeRemoteDataStore(itemExchangeRemote)
    }

    //<editor-fold desc="Get Bufferoos">
    @Test
    fun getItemExchangeCompletes() {
        // GIVEN
        stubItemExchangeCacheGetItem(Single.just(ItemExchangeFactory.makeItemEntityList(2)))
        val kw = randomUuid()
        val exact = randomBoolean()
        val type = randomInt()
        val sort = randomUuid()
        val sortDir = randomUuid()
        val sortServer = randomUuid()
        val sortRange = randomUuid()
        val page = randomInt()

        // WHEN
        val testObserver = itemExchangeRemote.getItems(kw, exact, type,
                sort, sortDir, sortServer, sortRange, page).test()

        // THEN
        testObserver.assertComplete()
    }
    //</editor-fold>

    //<editor-fold desc="Stub helper methods">
    private fun stubItemExchangeCacheGetItem(single: Single<List<ItemEntity>>) {
        whenever(itemExchangeRemote.getItems(any(), any(), any(), any(), any(), any(), any(), any())).thenReturn(single)
    }
    //</editor-fold>

}