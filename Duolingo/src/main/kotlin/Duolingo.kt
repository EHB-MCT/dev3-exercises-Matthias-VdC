import kotlin.system.exitProcess

open class Duolingo {
    var wrongAnswers = mutableListOf<String>()

    fun play() {
        var words = mutableListOf<Word>()
        var randomLanguage: Boolean? = null
        var t = 0
        var language = "random String"

        println("Do you want to choose a: Difficulty or Customize your own difficulty (type `Difficulty` or `Customize`)")
        var customize = readLine()

        if (customize == "Difficulty" || customize == "difficulty") {
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
        } else if(customize == "Customize" || customize == "customize"){
            println("What language do you want to practice? (French, English)")
            language = readLine()!!
            println("Please type in how many questions you want:")
            t = readLine()!!.toInt()
            randomLanguage = false
        }

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
        else{
            println("Please type in a valid response!")
            exitProcess(1)
        }

        words = words.shuffled().take(t).toMutableList()

        var count = t

        for (i in 0 until t) {
            println("$count questions left!")
            println("translate this word to Dutch: ${words[i].original}")
            var translate = readLine()
            if (count>0) {
                if (translate == words[i].translate) println("Good job! On to the next question!") else {
                    println("You were wrong! The answer was: ${words[i].translate}")
                    wrongAnswers.add(words[i].original)
                }
            }
            count--
        }
        println("You got these answers wrong: $wrongAnswers")
    }
}