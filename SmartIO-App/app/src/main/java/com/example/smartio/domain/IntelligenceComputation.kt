package com.example.smartio.domain

import kotlin.math.sqrt

class IntelligenceComputation(private val numbers: List<Int>) {

    companion object {
        var instance: IntelligenceComputation? = null
    }

    private val weightMatrixInstance = WeightMatrix()



    private fun calEuclideanDistance(): List<Pair<Int, Double>> {
        val distances = mutableListOf<Pair<Int, Double>>() // Lista de pares (índice de inteligencia, distancia euclidiana)
        val scores = mutableListOf<IntelligenceScore>()

        for ((i, weights) in weightMatrixInstance.getWeightMatrix().withIndex()) {
            var squaresSum = 0.0

            for ((i, response) in numbers.withIndex()) {
                val diference = response - weights[i]
                squaresSum += Math.pow(diference.toDouble(), 2.0)
            }

            val distance = sqrt(squaresSum)
            distances.add(Pair(i, distance))
            scores.add(IntelligenceScore(i, distance.toFloat()))
        }
        User.actualUser!!.scores = scores
        return distances
    }

    private fun getLesserIndexDistance(): Int {
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
        instance = this
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
    fun getIntelligenceDescription(): String {
        val intelligenceDescMap: Map<Int, String> = mapOf(
            0 to "La inteligencia espacial es la capacidad de percibir el mundo visual y espacial con precisión, de re-crear o transformar aspectos de lo que se ha percibido, de forma gráfica o mental, y de producir o re-crear formas, incluso para propósitos específicos.",
            1 to "La inteligencia musical es la capacidad de percibir, discriminar, transformar y expresar las formas musicales. Esta inteligencia incluye la sensibilidad al ritmo, al tono, a la melodía y al timbre.",
            2 to "La inteligencia lingüístico-verbal es la capacidad de usar las palabras de manera efectiva, tanto de forma oral como escrita. Esta inteligencia incluye la habilidad para manipular la sintaxis o la estructura de las oraciones, el significado o semántica de las palabras, el ritmo, la fonética o los sonidos de las palabras.",
            3 to "La inteligencia lógico-matemática es la capacidad de usar los números de manera efectiva y de razonar adecuadamente. Esta inteligencia incluye la sensibilidad a los esquemas y relaciones lógicas, las afirmaciones y las proposiciones (si-entonces, causa-efecto), las funciones y las abstracciones.",
            4 to "La inteligencia corporal-cinestésica es la capacidad de usar todo el cuerpo para expresar ideas y sentimientos (por ejemplo un actor, un mimo, un atleta o un bailarín). Incluye habilidades físicas como la coordinación, el equilibrio, la destreza, la fuerza, la flexibilidad y la velocidad, así como la percepción de medidas y volúmenes.",
            5 to "La inteligencia intrapersonal es la capacidad de formar un modelo preciso y verídico de uno mismo y de usarlo para operar de manera efectiva en la vida.",
            6 to "La inteligencia interpersonal es la capacidad de entender a los demás: qué los motiva, cómo trabajan, cómo trabajar cooperativamente con ellos. Entre los educadores se le conoce como inteligencia emocional o social.",
            7 to  "La inteligencia naturalista es la capacidad de distinguir, clasificar y utilizar elementos del medio ambiente, objetos, animales o plantas.",
            8 to "La inteligencia existencial es la capacidad de ubicarse y ubicar a los demás dentro del contexto de la vida, de formular y responder preguntas existenciales sobre el sentido de la vida, la muerte y la existencia.",
            9 to "La inteligencia creativa es la capacidad de crear nuevos productos o ideas. Incluye la habilidad de ver nuevas relaciones entre los elementos, de generar nuevas ideas y de unir cosas que normalmente no están relacionadas entre sí.",
            10 to "La inteligencia emocional es la capacidad de percibir y expresar emociones de manera adecuada, de entender las emociones y de emplear el conocimiento emocional en el pensamiento y en el razonamiento.",
            11 to "La inteligencia colaborativa es la capacidad de trabajar con otros de manera efectiva y productiva, de ser un miembro valioso de un equipo. Incluye la sensibilidad a los estados de ánimo, temperamentos y motivaciones de los demás."
        )
        return intelligenceDescMap[getLesserIndexDistance()].toString()
    }
}