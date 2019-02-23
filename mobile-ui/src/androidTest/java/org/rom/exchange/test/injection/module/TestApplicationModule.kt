package org.rom.exchange.test.injection.module

import android.app.Application
import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import org.buffer.android.boilerplate.cache.PreferencesHelper
import org.rom.exchange.data.executor.JobExecutor
import org.rom.exchange.data.repository.BufferooCache
import org.rom.exchange.data.repository.BufferooRemote
import org.rom.exchange.domain.executor.PostExecutionThread
import org.rom.exchange.domain.executor.ThreadExecutor
import org.rom.exchange.domain.repository.BufferooRepository
import org.rom.exchange.remote.BufferooService
import org.rom.exchange.UiThread
import org.rom.exchange.injection.scopes.PerApplication

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