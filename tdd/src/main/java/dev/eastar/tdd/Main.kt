package dev.eastar.tdd

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import dev.eastar.tdd.main.MainFr
import dev.eastar.tdd.main.MainViewModel

class Main : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit { replace(R.id.container, MainFr.newInstance()) }
        }

        viewModel.exit.observe(this) {
            finish()
        }

        viewModel.moveFragment.observe(this) { clz ->
            supportFragmentManager.commit { replace(R.id.container, clz.newInstance()) }
        }
    }
}