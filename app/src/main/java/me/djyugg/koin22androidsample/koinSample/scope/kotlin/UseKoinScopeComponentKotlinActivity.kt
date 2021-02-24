package me.djyugg.koin22androidsample.koinSample.scope.kotlin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import me.djyugg.koin22androidsample.R
import me.djyugg.koin22androidsample.koinSample.scope.SampleClass
import me.djyugg.koin22androidsample.koinSample.scope.SampleViewModel
import org.koin.androidx.scope.activityScope
import org.koin.androidx.viewmodel.ViewModelOwner
import org.koin.androidx.viewmodel.scope.getViewModel
import org.koin.core.scope.KoinScopeComponent
import org.koin.core.scope.Scope
import org.koin.core.scope.inject

class UseKoinScopeComponentKotlinActivity : AppCompatActivity(), KoinScopeComponent {
    // Fragmentの場合は fragmentScope() を利用
    override val scope: Scope by lazy { activityScope() }

    private val sampleClass by inject<SampleClass>()
    private val sampleViewModel by lazy<SampleViewModel> {
        scope.getViewModel(owner = { ViewModelOwner.from(this, this) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample_layout)

        sampleViewModel.text.observe(this, { findViewById<TextView>(R.id.text).text = it })

        val text = sampleClass.getText()
        sampleViewModel.updateText(text)
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.close()
    }

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, UseKoinScopeComponentKotlinActivity::class.java)
    }
}