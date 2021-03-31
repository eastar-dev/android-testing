package dev.eastar.tdd.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()
    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun exit() {
        val mainViewModel = MainViewModel()
        mainViewModel.exit()

        val observer = Observer<Lifecycle.Event<Unit>> {}
        try {
            val value = mainViewModel.exit.value
            MatcherAssert.assertThat(value.getContentIfNotHandled(), (Matchers.not(Matchers.nullValue())))

        } finally {
            // Whatever happens, don't forget to remove the observer!
            mainViewModel.exit.removeObserver(observer)
        }
    }

    @Test
    fun startSinglePlay() {
    }

    @Test
    fun startMultiPlay() {
    }
}