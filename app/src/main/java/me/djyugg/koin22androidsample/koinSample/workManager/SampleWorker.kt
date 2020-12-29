package me.djyugg.koin22androidsample.koinSample.workManager

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import me.djyugg.koin22androidsample.koinSample.scope.SampleClass

class SampleWorker(
    context: Context,
    workerParams: WorkerParameters,
    private val sampleClass: SampleClass
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result {
        Log.d("WorkManager", sampleClass.getText())
        return Result.success()
    }
}