package dev.eastar.tdd.data

import kotlin.random.Random

class GeneratorRandomNumberSourceImpl : GeneratorRandomNumberSource{
    override fun getRandomNumber1between100(): Int {
        return Random.nextInt(1,101)
    }
}