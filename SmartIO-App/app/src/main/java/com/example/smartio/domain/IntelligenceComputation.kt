package com.example.smartio.domain

class IntelligenceComputation(private val numbers: List<Int>) {

    val weightMatrixInstance = WeightMatrix()

    fun multiplyWithWeightMatrix(): List<List<Int>> {
        val resultMatrix = mutableListOf<List<Int>>()
        for (row in weightMatrixInstance.getWeightMatrix()) {
            val resultRow = mutableListOf<Int>()
            for (i in row.indices) {
                resultRow.add(row[i] * numbers[i])
            }
            resultMatrix.add(resultRow)
        }
        return resultMatrix
    }

    fun sumRows(): List<Int> {
        val result = mutableListOf<Int>()
        for (row in multiplyWithWeightMatrix()) {
            val sum = row.sum()
            result.add(sum)
        }
        return result
    }

    fun getMaxPosition(): Int {
        var max = Int.MIN_VALUE
        var maxPosition = -1

        for ((index, sum) in sumRows().withIndex()) {
            if (sum > max) {
                max = sum
                maxPosition = index
            }
        }
        return maxPosition
    }

    fun getIntelligence(): String? {
        val intelligenceMap: Map<Int, String> = mapOf(
            0 to "Inteligencia espacial",
            1 to "Inteligencia musical",
            2 to "Inteligencia lingüístico-verbal",
            3 to "Inteligencia lógico-matemática",
            4 to "Inteligencia corporal-cinestésica",
            5 to "Inteligencia intrapersonal",
            6 to "Inteligencia interpersonal",
            7 to "Inteligencia naturalista",
            8 to "Inteligencia existencial",
            9 to "Inteligencia creativa",
            10 to "Inteligencia emocional",
            11 to "Inteligencia colaborativa"
        )

        return intelligenceMap[getMaxPosition()]
    }
}