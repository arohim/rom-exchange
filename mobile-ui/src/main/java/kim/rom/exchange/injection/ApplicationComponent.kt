package kim.rom.exchange.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import kim.rom.exchange.ROMExchangeApplication
import kim.rom.exchange.injection.module.ActivityBindingModule
import kim.rom.exchange.injection.module.ApplicationModule
import kim.rom.exchange.injection.scopes.PerApplication

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
