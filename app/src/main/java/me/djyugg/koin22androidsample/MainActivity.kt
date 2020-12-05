package me.djyugg.koin22androidsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import me.djyugg.koin22androidsample.koinSample.scope.java.UseScopeActivityJavaActivity
import me.djyugg.koin22androidsample.koinSample.scope.java.UseScopeJavaActivity
import me.djyugg.koin22androidsample.koinSample.scope.kotlin.UseKoinScopeComponentKotlinActivity
import me.djyugg.koin22androidsample.koinSample.scope.kotlin.UseScopeActivityKotlinActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.button1).setOnClickListener {
            startActivity(UseScopeActivityKotlinActivity.createIntent(this))
        }

        findViewById<Button>(R.id.button2).setOnClickListener {
            startActivity(UseKoinScopeComponentKotlinActivity.createIntent(this))
        }

        findViewById<Button>(R.id.button3).setOnClickListener {
            startActivity(UseScopeActivityJavaActivity.createIntent(this))
        }

        findViewById<Button>(R.id.button4).setOnClickListener {
            startActivity(UseScopeJavaActivity.createIntent(this))
        }
    }
}