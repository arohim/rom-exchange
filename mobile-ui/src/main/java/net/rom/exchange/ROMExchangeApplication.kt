package net.rom.exchange

import android.app.Activity
import android.app.Application
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import net.danlew.android.joda.JodaTimeAndroid
import net.rom.exchange.injection.DaggerApplicationComponent
import timber.log.Timber
import javax.inject.Inject

class ROMExchangeApplication : Application(), HasSupportFragmentInjector, HasActivityInjector {

    @Inject
    lateinit var activityDispatchingAndroidSupportInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
        setupTimber()
    }

    private fun setupTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return activityDispatchingAndroidSupportInjector
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

}
