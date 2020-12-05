package me.djyugg.koin22androidsample

import android.app.Application
import me.djyugg.koin22androidsample.koinSample.module.sampleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SampleApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleApplication)
            androidLogger(level = Level.DEBUG)
            modules(sampleModule)
        }
    }
}