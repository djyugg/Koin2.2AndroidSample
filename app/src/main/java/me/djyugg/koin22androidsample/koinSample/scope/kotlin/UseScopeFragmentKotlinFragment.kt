package me.djyugg.koin22androidsample.koinSample.scope.kotlin

import android.os.Bundle
import android.view.View
import android.widget.TextView
import me.djyugg.koin22androidsample.R
import me.djyugg.koin22androidsample.koinSample.scope.LinkToSampleViewModel
import me.djyugg.koin22androidsample.koinSample.scope.SampleClass
import org.koin.androidx.scope.ScopeFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class UseScopeFragmentKotlinFragment : ScopeFragment(R.layout.fragment_sample_layout) {
    private val sampleClass: SampleClass by inject()
    private val linkToSampleViewModel: LinkToSampleViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        linkToSampleViewModel.text.observe(
            viewLifecycleOwner,
            { view.findViewById<TextView>(R.id.text).text = it }
        )

        val text = sampleClass.getText()
        linkToSampleViewModel.updateText(text)
    }
}