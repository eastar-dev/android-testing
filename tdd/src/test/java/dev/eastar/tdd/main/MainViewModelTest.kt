package dev.eastar.tdd.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.MatcherAssert
import org.hamcrest.Matchers.`is`
import org.junit.*
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

    @Test
    fun startSinglePlay() {
        //given
        val mainViewModel = MainViewModel()

        // When startSinglePlay
        mainViewModel.startSinglePlay().observeForever { actual ->
            //then
            Assert.assertEquals(actual, SingleFr::class.java)//3
        }
    }

    @Test
    fun startMultiPlay() {
        val mainViewModel = MainViewModel()
        mainViewModel.startMultiPlay()

        val observer = Observer<Class<out Fragment>> {}
        try {
            val actual = mainViewModel.moveFragment.value
            Assert.assertEquals(actual, MultiFr::class.java)//3

        } finally {
            // Whatever happens, don't forget to remove the observer!
            mainViewModel.moveFragment.removeObserver(observer)
        }
    }
    //@Test
    //fun startMultiPlay() {
    //    val mainViewModel = MainViewModel()
    //    mainViewModel.startMultiPlay()
    //
    //    val observer = Observer<Class<out Fragment>> {}
    //    try {
    //        val value = mainViewModel.moveFragment.value
    //        MatcherAssert.assertThat(value, `is`(MultiFr::class))
    //
    //    } finally {
    //        // Whatever happens, don't forget to remove the observer!
    //        mainViewModel.moveFragment.removeObserver(observer)
    //    }
    //}
}