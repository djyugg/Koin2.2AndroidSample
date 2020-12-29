package me.djyugg.koin22androidsample

import android.app.Application
import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import androidx.work.WorkManager
import me.djyugg.koin22androidsample.koinSample.scope.module.sampleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.workmanager.factory.KoinWorkerFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class SampleApplication : Application(), Configuration.Provider {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@SampleApplication)
            androidLogger(level = Level.DEBUG)
            modules(sampleModule)
        }
    }

    override fun getWorkManagerConfiguration(): Configuration {
        return Configuration.Builder().also { builder ->
            val workerFactory =
                DelegatingWorkerFactory().also { it.addFactory(KoinWorkerFactory()) }
            builder.setWorkerFactory(workerFactory)
        }.build()
    }
}