package me.djyugg.koin22androidsample.koinSample.scope.java;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.Nullable;
import org.koin.androidx.scope.ComponentActivityExtKt;
import org.koin.androidx.viewmodel.ViewModelOwner;
import org.koin.androidx.viewmodel.scope.ScopeExtKt;
import org.koin.core.scope.Scope;

import kotlin.jvm.JvmClassMappingKt;
import me.djyugg.koin22androidsample.R;
import me.djyugg.koin22androidsample.koinSample.scope.SampleClass;
import me.djyugg.koin22androidsample.koinSample.scope.SampleViewModel;


public class UseScopeJavaActivity extends AppCompatActivity {

    private Scope scope;

    private SampleClass sampleClass;
    private SampleViewModel sampleViewModel;

    public static Intent createIntent(Context context) {
        return new Intent(context, UseScopeJavaActivity.class);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_layout);

        scope = ComponentActivityExtKt.activityScope(this);

        sampleClass = scope.get(SampleClass.class);
        sampleViewModel = ScopeExtKt.getViewModel(
                scope,
                null,
                null,
                () -> ViewModelOwner.Companion.from(
                        UseScopeJavaActivity.this,
                        UseScopeJavaActivity.this
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        scope.close();
    }
}
