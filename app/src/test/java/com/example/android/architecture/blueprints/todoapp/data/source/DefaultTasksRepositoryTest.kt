package com.example.android.architecture.blueprints.todoapp.data.source

import com.example.android.architecture.blueprints.todoapp.data.Result
import com.example.android.architecture.blueprints.todoapp.data.Task
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class DefaultTasksRepositoryTest {
    private val task1 = Task("Title1", "Description1")
    private val task2 = Task("Title2", "Description2")
    private val task3 = Task("Title3", "Description3")
    private val remoteTasks = listOf(task1, task2).sortedBy { it.id }
    private val localTasks = listOf(task3).sortedBy { it.id }
    private val newTasks = listOf(task3).sortedBy { it.id }

    private lateinit var tasksRemoteDataSource: FakeDataSource
    private lateinit var tasksLocalDataSource: FakeDataSource

    // Class under test
    private lateinit var tasksRepository: DefaultTasksRepository

    @Before
    fun setUp() {
        tasksRemoteDataSource = FakeDataSource(remoteTasks.toMutableList())
        tasksLocalDataSource = FakeDataSource(localTasks.toMutableList())
        // Get a reference to the class under test
        tasksRepository = DefaultTasksRepository(
            // TODO Dispatchers.Unconfined는 Dispatchers.Main으로 대체되어야합니다.
            //  이것은 코루틴 + 테스팅에 대해 더 많이 이해해야하므로 지금은 Unconfined로 유지하겠습니다.
            tasksRemoteDataSource, tasksLocalDataSource, Dispatchers.Unconfined
        )
    }

    @Test
    fun getTasks_requestsAllTasksFromRemoteDataSource() = runBlockingTest {
        // When tasks are requested from the tasks repository
        val tasks = tasksRepository.getTasks(true) as Result.Success

        // Then tasks are loaded from the remote data source
        assertThat(tasks.data, IsEqual(remoteTasks))
    }
}