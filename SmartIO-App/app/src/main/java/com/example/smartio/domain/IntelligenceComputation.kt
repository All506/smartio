package com.example.smartio.domain

import kotlin.math.sqrt

class IntelligenceComputation(private val numbers: List<Int>) {

    val weightMatrixInstance = WeightMatrix()


    fun calEuclideanDistance(): List<Pair<Int, Double>> {
        val distances = mutableListOf<Pair<Int, Double>>() // Lista de pares (índice de inteligencia, distancia euclidiana)

        for ((i, weights) in weightMatrixInstance.getWeightMatrix().withIndex()) {
            var squaresSum = 0.0

            for ((i, response) in numbers.withIndex()) {
                val diference = response - weights[i]
                squaresSum += Math.pow(diference.toDouble(), 2.0)
            }

            val distance = sqrt(squaresSum)
            distances.add(Pair(i, distance))
        }
        return distances;
    }

    fun getLesserIndexDistance(): Int {
        val distances = calEuclideanDistance()
        var indexMinorDistance = -1
        var shorterDistance = Double.MAX_VALUE

        for ((i, distance) in distances) {
            if (distance < shorterDistance) {
                shorterDistance = distance
                indexMinorDistance = i
            }
        }

        return indexMinorDistance
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
        return intelligenceMap[getLesserIndexDistance()]
    }
}