package kim.rom.exchange.test.injection.module

import android.app.Application
import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.cache.PreferencesHelper
import kim.rom.exchange.data.executor.JobExecutor
import kim.rom.exchange.data.repository.BufferooCache
import kim.rom.exchange.data.repository.BufferooRemote
import kim.rom.exchange.domain.executor.PostExecutionThread
import kim.rom.exchange.domain.executor.ThreadExecutor
import kim.rom.exchange.domain.repository.BufferooRepository
import kim.rom.exchange.remote.BufferooService
import kim.rom.exchange.UiThread
import kim.rom.exchange.injection.scopes.PerApplication

@Module
class TestApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(): PreferencesHelper {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRepository(): BufferooRepository {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(): BufferooCache {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(): BufferooRemote {
        return mock()
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
        return mock()
    }

}