package me.djyugg.koin22androidsample.koinSample.workManager

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import me.djyugg.koin22androidsample.R

class WorkManagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_layout)

        val request = OneTimeWorkRequest.from(SampleWorker::class.java)
        WorkManager.getInstance(this).enqueue(request)
    }

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, WorkManagerActivity::class.java)
    }
}