package net.rom.exchange.data.source

import com.nhaarman.mockito_kotlin.mock
import net.rom.exchange.data.repository.ItemExchangeDataStore
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import kotlin.test.assertTrue

@RunWith(JUnit4::class)
class ItemExchangeDataStoreFactoryTest {

    private lateinit var itemExchangeDataStoreFactory: ItemExchangeDataStoreFactory

    @Before
    fun setUp() {
        itemExchangeDataStoreFactory = ItemExchangeDataStoreFactory(mock())
    }

    @Test
    fun retrieveDataStore() {
        // GIVEN

        // WHEN
        val actual = itemExchangeDataStoreFactory.retrieveDataStore()

        // THEN
        assertTrue(actual is ItemExchangeDataStore)
    }

}