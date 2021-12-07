import java.lang.Exception
import kotlin.system.exitProcess

open class Duolingo {
    var wrongAnswers = mutableListOf<String>()

    fun play() {
        var words = mutableListOf<Word>()
        var randomLanguage: Boolean? = null
        var t = 0
        var language = "random String"
        var difficulty = 1

        println("Do you want to choose a: Difficulty or Customize your own difficulty (type `Difficulty` or `Customize`)")
        var customize = readLine()

        if (customize == "Difficulty" || customize == "difficulty") {
        try {
                println("What difficulty do you want? (Easy / Hard)")
                var questionNr = readLine()

                if (questionNr == "Easy" || questionNr == "easy") {
                    t = 3
                    randomLanguage = false
                    println("What language do you want to practice? (French, English)")
                    language = readLine()!!
                } else if (questionNr == "Hard" || questionNr == "hard") {
                    t = 6
                    randomLanguage = true
                }

        } catch(e: Exception){
            println("You have responded with an invalid answer")
        }

        } else if(customize == "Customize" || customize == "customize"){
            try {
            println("What language do you want to practice? (French, English)")
            language = readLine()!!
            println("Please type in how many questions you want:")
            t = readLine()!!.toInt()
            randomLanguage = false
            }catch (e:Exception){
                println("You have responded with an invalid answer")
                exitProcess(1)
            }
        }

        try {
            if (!randomLanguage!!) {
                if (language == "French" || language == "french"){
                    words = FrenchWord().words
                }
                if (language == "English" || language == "english"){
                    words = EnglishWord().words
                }
            }else if(randomLanguage!!){
                words = FrenchWord().words
                words += EnglishWord().words
            }
        }
        catch(e:Exception){
            println("You have responded with an invalid answer")
            exitProcess(1)
        }

        var count = t

        words = words.shuffled().take(20).toMutableList()

        for (i in 0 until t) {
            if (i == count) {
                difficulty = words[i].difficulty
            }
            var easyWords = words.filter { it.difficulty == 1 }.toMutableList()
            var difficultWords = words.filter { it.difficulty == 2 }.toMutableList()
            var translate: String? = null

            if (count>0) {
                if(difficulty == 1) {
                    println("$count questions left!")
                    println("translate this word to Dutch: ${easyWords[i].original}")
                    translate = readLine()
                    if (translate == easyWords[i].translate){
                        println("Good job! On to the next question!")
                        difficulty = 2
                    } else {
                        println("You were wrong! The answer was: ${easyWords[i].translate}")
                        wrongAnswers.add(easyWords[i].original)
                        difficulty = 1
                    }
                }else if(difficulty == 2){
                    println("$count questions left!")
                    println("translate this word to Dutch: ${difficultWords[i].original}")
                    translate = readLine()
                    if (translate == difficultWords[i].translate){
                        println("Good job! On to the next question!")
                        difficulty = 2
                    } else {
                        println("You were wrong! The answer was: ${difficultWords[i].translate}")
                        wrongAnswers.add(difficultWords[i].original)
                        difficulty = 1
                    }
                }

            }
            count--
        }
        println("You got these answers wrong: $wrongAnswers")
    }
}