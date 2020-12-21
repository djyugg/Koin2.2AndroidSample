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

class UseScopeActivityWithFragmentKotlinActivity : ScopeActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_with_fragment_sample_layout)
    }

    companion object {
        fun createIntent(context: Context): Intent =
            Intent(context, UseScopeActivityWithFragmentKotlinActivity::class.java)
    }
}