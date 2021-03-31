package dev.eastar.tdd

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dev.eastar.tdd.main.MainFr
import dev.eastar.tdd.main.MainViewModel

class Main : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFr.newInstance())
                .commitNow()
        }

        viewModel.exit.observe(this) {
            finish()
        }
    }
}