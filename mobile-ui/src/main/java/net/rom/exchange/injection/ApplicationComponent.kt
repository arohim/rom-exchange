package net.rom.exchange.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import net.rom.exchange.ROMExchangeApplication
import net.rom.exchange.injection.module.ActivityBindingModule
import net.rom.exchange.injection.module.ApplicationModule
import net.rom.exchange.injection.scopes.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: ROMExchangeApplication)

}
