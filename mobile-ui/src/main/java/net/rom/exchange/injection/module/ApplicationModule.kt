package net.rom.exchange.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import net.rom.exchange.BuildConfig
import net.buffer.android.boilerplate.cache.BufferooCacheImpl
import net.buffer.android.boilerplate.cache.PreferencesHelper
import net.buffer.android.boilerplate.cache.db.DbOpenHelper
import net.buffer.android.boilerplate.cache.mapper.BufferooEntityMapper
import net.rom.exchange.data.BufferooDataRepository
import net.rom.exchange.data.executor.JobExecutor
import net.rom.exchange.data.mapper.BufferooMapper
import net.rom.exchange.data.repository.BufferooCache
import net.rom.exchange.data.repository.BufferooRemote
import net.rom.exchange.data.source.BufferooDataStoreFactory
import net.rom.exchange.domain.executor.PostExecutionThread
import net.rom.exchange.domain.executor.ThreadExecutor
import net.rom.exchange.domain.repository.BufferooRepository
import net.rom.exchange.UiThread
import net.rom.exchange.data.ItemExchangeDataRepository
import net.rom.exchange.data.mapper.rom.ItemExchangeMapper
import net.rom.exchange.data.repository.ItemExchangeRemote
import net.rom.exchange.data.source.ItemExchangeDataStoreFactory
import net.rom.exchange.domain.repository.ItemExchangeRepository
import net.rom.exchange.injection.scopes.PerApplication
import net.rom.exchange.remote.*
import net.rom.exchange.remote.mapper.rom.ItemEntityMapper

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(factory: BufferooDataStoreFactory,
                                           mapper: BufferooMapper): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: net.buffer.android.boilerplate.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: BufferooService,
                                       factory: net.rom.exchange.remote.mapper.BufferooEntityMapper): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideItemExchangeDataRepository(factory: ItemExchangeDataStoreFactory, mapper: ItemExchangeMapper): ItemExchangeRepository {
        return ItemExchangeDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideItemExchangeRemote(service: ItemExchangeService,
                                          factory: ItemEntityMapper): ItemExchangeRemote {
        return ItemExchangeRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): BufferooService {
        return BufferooServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
    }

    @Provides
    @PerApplication
    internal fun provideItemExchangeService(): ItemExchangeService {
        return ItemExchangeServiceFactory.makeItemExchangeService(BuildConfig.DEBUG)
    }
}
