package dev.eastar.tdd.data

import dev.eastar.tdd.data.source.GeneratorRandomNumberSourceImpl
import org.hamcrest.CoreMatchers.allOf
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers
import org.hamcrest.collection.IsIn
import org.hamcrest.core.Is.`is`
import org.junit.Test
import java.lang.Integer.max
import java.lang.Integer.min


class GeneratorRandomNumberSourceImplTest {

    @Test
    fun getRandomNumber1between100() {
        //given
        val generatorRandomNumberSource = GeneratorRandomNumberSourceImpl()
        repeat(10000) {
            //when
            val actual: Int = generatorRandomNumberSource.getRandomNumber1between100()
            //then
            assertThat(actual, IsIn((0..100).toList()))
        }
    }

    @Test
    fun getManyRandomNumberMin1Max100() {
        //given
        val generatorRandomNumberSource = GeneratorRandomNumberSourceImpl()
        //when
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        repeat(100000) {
            val actual: Int = generatorRandomNumberSource.getRandomNumber1between100()
            min = min(min, actual)
            max = max(max, actual)
        }
        //then
        assertThat(min, `is`(1))
        assertThat(max, `is`(100))
    }
}