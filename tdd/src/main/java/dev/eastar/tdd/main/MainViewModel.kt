package dev.eastar.tdd.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    val exit = MutableLiveData<Unit>()
    val moveFragment = MutableLiveData<Class<out Fragment>>()

    fun exit() {
        exit.value = Unit
    }

    fun startSinglePlay(): MutableLiveData<Class<out Fragment>> {
        moveFragment.value = SingleFr::class.java
        return moveFragment
    }

    fun startMultiPlay() {
        moveFragment.value = MultiFr::class.java
    }
}