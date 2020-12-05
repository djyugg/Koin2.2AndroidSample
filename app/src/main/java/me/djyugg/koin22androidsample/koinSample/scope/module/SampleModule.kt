package me.djyugg.koin22androidsample.koinSample.scope.module

import me.djyugg.koin22androidsample.koinSample.scope.SampleClass
import me.djyugg.koin22androidsample.koinSample.scope.SampleViewModel
import me.djyugg.koin22androidsample.koinSample.scope.java.UseScopeActivityJavaActivity
import me.djyugg.koin22androidsample.koinSample.scope.java.UseScopeJavaActivity
import me.djyugg.koin22androidsample.koinSample.scope.kotlin.UseKoinScopeComponentKotlinActivity
import me.djyugg.koin22androidsample.koinSample.scope.kotlin.UseScopeActivityKotlinActivity
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val sampleModule = module {
    scope<UseScopeActivityKotlinActivity> {
        scoped { SampleClass() }
        viewModel { SampleViewModel() }
    }

    scope<UseScopeActivityJavaActivity> {
        scoped { SampleClass() }
        viewModel { SampleViewModel() }
    }


    scope<UseKoinScopeComponentKotlinActivity> {
        scoped { SampleClass() }
        viewModel { SampleViewModel() }
    }

    scope<UseScopeJavaActivity> {
        scoped { SampleClass() }
        viewModel { SampleViewModel() }
    }

}