package net.rom.exchange.test.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import net.rom.exchange.domain.executor.PostExecutionThread
import net.rom.exchange.domain.repository.BufferooRepository
import net.rom.exchange.injection.ApplicationComponent
import net.rom.exchange.injection.module.ActivityBindingModule
import net.rom.exchange.test.injection.module.TestApplicationModule
import net.rom.exchange.injection.scopes.PerApplication
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
        fun application(application: Application): Builder

        fun build(): TestApplicationComponent
    }

}