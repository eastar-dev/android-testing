package dev.eastar.tdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dev.eastar.tdd.main.MainFr

class Main : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFr.newInstance())
                .commitNow()
        }
    }
}