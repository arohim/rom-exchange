package org.buffer.android.boilerplate.ui.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import org.buffer.android.boilerplate.domain.executor.PostExecutionThread
import org.buffer.android.boilerplate.domain.repository.BufferooRepository
import kim.rom.exchange.injection.ApplicationComponent
import kim.rom.exchange.injection.module.ActivityBindingModule
import org.buffer.android.boilerplate.ui.injection.module.TestApplicationModule
import kim.rom.exchange.injection.scopes.PerApplication
import org.buffer.android.boilerplate.ui.test.TestApplication

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