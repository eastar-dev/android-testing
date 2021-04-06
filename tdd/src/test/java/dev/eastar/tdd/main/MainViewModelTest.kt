package dev.eastar.tdd.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import dev.eastar.tdd.InstantExecutorExtension
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers.`is`
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.RegisterExtension

@ExtendWith(InstantExecutorExtension::class)
class MainViewModelTest {

    @Test
    fun exit() {
        val mainViewModel = MainViewModel()
        mainViewModel.exit()

        val observer = Observer<Unit> {}
        try {
            mainViewModel.exit.observeForever(observer)
            val value = mainViewModel.exit.value
            MatcherAssert.assertThat(value, `is`(Unit))

        } finally {
            // Whatever happens, don't forget to remove the observer!
            mainViewModel.exit.removeObserver(observer)
        }
    }

}