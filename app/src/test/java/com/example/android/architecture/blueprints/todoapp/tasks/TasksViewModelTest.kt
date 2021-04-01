package com.example.android.architecture.blueprints.todoapp.tasks

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.android.architecture.blueprints.todoapp.Event
import com.example.android.architecture.blueprints.todoapp.getOrAwaitValue
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.not
import org.hamcrest.Matchers.nullValue
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TasksViewModelTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    lateinit var tasksViewModel: TasksViewModel

    @Before
    fun setupViewModel() {
        tasksViewModel = TasksViewModel(ApplicationProvider.getApplicationContext())
    }

    @Test
    fun `addNewTask 생성하기`() {
        // Given a fresh TasksViewModel
        val tasksViewModel = this.tasksViewModel

        // When adding a new task
        tasksViewModel.addNewTask()

        //val value = tasksViewModel.newTaskEvent.getOrAwaitValue()

        //val v = value.getContentIfNotHandled()
        //System.out.println(v.toString())
        //assertThat(value.getContentIfNotHandled(), (not(nullValue())))

        // Create observer - no need for it to do anything!
        val observer = Observer<Event<Unit>> {}
        try {

            // Observe the LiveData forever
            tasksViewModel.newTaskEvent.observeForever(observer)

            // When adding a new task
            tasksViewModel.addNewTask()

            // Then the new task event is triggered
            val value = tasksViewModel.newTaskEvent.value
            assertThat(value?.getContentIfNotHandled(), (not(nullValue())))

        } finally {
            // Whatever happens, don't forget to remove the observer!
            tasksViewModel.newTaskEvent.removeObserver(observer)
        }
    }

    @Test
    fun setFilterAllTasks_tasksAddViewVisible() {

        // Given a fresh ViewModel
        val tasksViewModel = this.tasksViewModel


        // When the filter type is ALL_TASKS
        tasksViewModel.setFiltering(TasksFilterType.ALL_TASKS)


        // Then the "Add task" action is visible
        val result = tasksViewModel.tasksAddViewVisible.getOrAwaitValue()
        MatcherAssert.assertThat(true, `is`(result))
    }


    //@Test
    //fun setFiltering() {
    //}
    //
    //@Test
    //fun clearCompletedTasks() {
    //}
    //
    //@Test
    //fun completeTask() {
    //}
    //
    //
    //
    //@Test
    //fun openTask() {
    //}
    //
    //@Test
    //fun showEditResultMessage() {
    //}
    //
    //@Test
    //fun loadTasks() {
    //}
    //
    //@Test
    //fun refresh() {
    //}
}