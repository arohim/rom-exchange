package kim.rom.exchange.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import kim.rom.exchange.BuildConfig
import org.buffer.android.boilerplate.cache.BufferooCacheImpl
import org.buffer.android.boilerplate.cache.PreferencesHelper
import org.buffer.android.boilerplate.cache.db.DbOpenHelper
import org.buffer.android.boilerplate.cache.mapper.BufferooEntityMapper
import kim.rom.exchange.data.BufferooDataRepository
import kim.rom.exchange.data.executor.JobExecutor
import kim.rom.exchange.data.mapper.BufferooMapper
import kim.rom.exchange.data.repository.BufferooCache
import kim.rom.exchange.data.repository.BufferooRemote
import kim.rom.exchange.data.source.BufferooDataStoreFactory
import kim.rom.exchange.domain.executor.PostExecutionThread
import kim.rom.exchange.domain.executor.ThreadExecutor
import kim.rom.exchange.domain.repository.BufferooRepository
import kim.rom.exchange.UiThread
import kim.rom.exchange.data.ROMExchangeDataRepository
import kim.rom.exchange.data.mapper.rom.ItemMapper
import kim.rom.exchange.data.repository.ROMExchangeRemote
import kim.rom.exchange.data.source.ROMExchangeDataStoreFactory
import kim.rom.exchange.domain.repository.ROMExchangeRepository
import kim.rom.exchange.injection.scopes.PerApplication
import kim.rom.exchange.remote.*

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
                                      mapper: org.buffer.android.boilerplate.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: BufferooService,
                                       factory: kim.rom.exchange.remote.mapper.BufferooEntityMapper): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideROMExchangeDataRepository(factory: ROMExchangeDataStoreFactory, mapper: ItemMapper): ROMExchangeRepository {
        return ROMExchangeDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideROMExchangeRemote(service: ROMExchangeService,
                                          factory: kim.rom.exchange.remote.mapper.rom.ItemEntityMapper): ROMExchangeRemote {
        return ROMExchangeRemoteImpl(service, factory)
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
    internal fun provideROMExchangeService(): ROMExchangeService {
        return ROMExchangeServiceFactory.makeROMExchangeService(BuildConfig.DEBUG)
    }
}
