package org.rom.exchange.test.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import org.rom.exchange.domain.executor.PostExecutionThread
import org.rom.exchange.domain.repository.BufferooRepository
import org.rom.exchange.injection.ApplicationComponent
import org.rom.exchange.injection.module.ActivityBindingModule
import org.rom.exchange.test.injection.module.TestApplicationModule
import org.rom.exchange.injection.scopes.PerApplication
import org.rom.exchange.test.test.TestApplication

@Component(modules = arrayOf(TestApplicationModule::class, ActivityBindingModule::class,
        AndroidSupportInjectionModule::class))
@PerApplication
interface TestApplicationComponent : ApplicationComponent {

    fun bufferooRepository(): BufferooRepository

    fun postExecutionThread(): PostExecutionThread

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

}