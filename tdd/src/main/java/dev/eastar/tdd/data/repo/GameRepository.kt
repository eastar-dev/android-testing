package dev.eastar.tdd.data.repo

interface GameRepository {
    fun generatRandomNumber()
    fun tryNumberResult(number: Int, who: String)
}
