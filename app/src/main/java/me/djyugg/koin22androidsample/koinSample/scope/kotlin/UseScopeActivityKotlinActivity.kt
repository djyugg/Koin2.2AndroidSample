package me.djyugg.koin22androidsample.koinSample.scope.kotlin

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import me.djyugg.koin22androidsample.R
import me.djyugg.koin22androidsample.koinSample.scope.SampleClass
import me.djyugg.koin22androidsample.koinSample.scope.SampleViewModel
import org.koin.androidx.scope.ScopeActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class UseScopeActivityKotlinActivity : ScopeActivity() {

    private val sampleClass by inject<SampleClass>()
    private val sampleViewModel by viewModel<SampleViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_layout)

        sampleViewModel.text.observe(this, { findViewById<TextView>(R.id.text).text = it })

        val text = sampleClass.getText()
        sampleViewModel.updateText(text)
    }

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, UseScopeActivityKotlinActivity::class.java)
    }
}