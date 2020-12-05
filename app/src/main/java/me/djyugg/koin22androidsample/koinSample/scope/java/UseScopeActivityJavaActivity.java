package me.djyugg.koin22androidsample.koinSample.scope.java;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.jetbrains.annotations.Nullable;
import org.koin.androidx.scope.ScopeActivity;
import org.koin.androidx.viewmodel.ViewModelOwner;
import org.koin.androidx.viewmodel.ext.android.ScopedActivityExtKt;

import kotlin.jvm.JvmClassMappingKt;
import me.djyugg.koin22androidsample.R;
import me.djyugg.koin22androidsample.koinSample.scope.SampleClass;
import me.djyugg.koin22androidsample.koinSample.scope.SampleViewModel;

public class UseScopeActivityJavaActivity extends ScopeActivity {
    private SampleClass sampleClass;
    private SampleViewModel sampleViewModel;

    public static Intent createIntent(Context context) {
        return new Intent(context, UseScopeActivityJavaActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_layout);

        sampleClass = getScope().get(SampleClass.class);
        sampleViewModel = ScopedActivityExtKt.getViewModel(
                this,
                null,
                null,
                () -> ViewModelOwner.Companion.from(
                        UseScopeActivityJavaActivity.this,
                        UseScopeActivityJavaActivity.this
                ),
                JvmClassMappingKt.getKotlinClass(SampleViewModel.class),
                null
        );

        sampleViewModel.getText().observe(this, text -> {
            final TextView view = findViewById(R.id.text);
            view.setText(text);
        });

        final String text = sampleClass.getText();
        sampleViewModel.updateText(text);
    }
}
