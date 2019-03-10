package net.rom.exchange.remote

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Single
import net.rom.exchange.data.model.rom.ItemExchangeEntity
import net.rom.exchange.remote.factory.DataFactory.Factory.randomBoolean
import net.rom.exchange.remote.factory.DataFactory.Factory.randomInt
import net.rom.exchange.remote.factory.DataFactory.Factory.randomUuid
import net.rom.exchange.remote.factory.ItemExchangeFactory
import net.rom.exchange.remote.mapper.rom.ItemEntityMapper
import net.rom.exchange.remote.model.rom.ItemExchangeModel
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ItemRemoteImplTest {

    private lateinit var entityMapper: ItemEntityMapper
    private lateinit var service: ItemExchangeService

    private lateinit var remoteImpl: ItemExchangeRemoteImpl

    @Before
    fun setup() {
        entityMapper = mock()
        service = mock()
        remoteImpl = ItemExchangeRemoteImpl(service, entityMapper)
    }

    //<editor-fold desc="Get Items">
    @Test
    fun getItemExchangeCompletes() {
        // GIVEN
        stubItemExchangeServiceGetItems(Single.just(ItemExchangeFactory.makeItemExchangeModelList(5)))
        val kw = randomUuid()
        val exact = randomBoolean()
        val type = randomInt()
        val sort = randomUuid()
        val sortDir = randomUuid()
        val sortServer = randomUuid()
        val sortRange = randomUuid()
        val page = randomInt()

        // WHEN
        val testObserver = remoteImpl.getItems(kw, exact, type, sort, sortDir, sortServer, sortRange, page).test()

        // THEN
        testObserver.assertComplete()
    }

    @Test
    fun getItemsReturnsData() {
        // GIVEN
        val response = ItemExchangeFactory.makeItemExchangeModelList(5)
        stubItemExchangeServiceGetItems(Single.just(response))
        val entities = mutableListOf<ItemExchangeEntity>()
        response.forEach {
            entities.add(entityMapper.mapFromRemote(it))
        }
        val kw = randomUuid()
        val exact = randomBoolean()
        val type = randomInt()
        val sort = randomUuid()
        val sortDir = randomUuid()
        val sortServer = randomUuid()
        val sortRange = randomUuid()
        val page = randomInt()

        // WHEN
        val testObserver = remoteImpl.getItems(kw, exact, type, sort, sortDir, sortServer, sortRange, page).test()

        // THEN
        testObserver.assertValue(entities)
    }

    //</editor-fold>
    private fun stubItemExchangeServiceGetItems(single: Single<List<ItemExchangeModel>>) {
        whenever(service.getItems(any(), any(), any(), any(), any(), any(), any())).thenReturn(single)
    }
}