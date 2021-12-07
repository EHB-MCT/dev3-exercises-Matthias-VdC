open class Duolingo {
    var wrongAnswers = mutableListOf<String>()
    var words = mutableListOf<Word>(
        Word("Bonjour", "Hallo", "French"),
        Word("Au revoir", "Tot ziens", "French"),
        Word("Oui", "Ja", "French"),
        Word("Non", "Nee", "French"),
        Word("Merci", "Bedankt", "French"),
        Word("Chat", "Kat", "French"),
        Word("Chien", "Hond", "French"),
        Word("Bonne nuit", "Welterusten", "French"),
        Word("Monde", "Wereld", "French"),
        Word("Raison", "Redenen", "French"),
        Word("Hello", "Hallo", "English"),
        Word("Goodbye", "Tot ziens", "English"),
        Word("Yes", "Ja", "English"),
        Word("No", "Nee", "English"),
        Word("Thank you", "Bedankt", "English"),
        Word("Cat", "Kat", "English"),
        Word("Dog", "Hond", "English"),
        Word("Good night", "Welterusten", "English"),
        Word("World", "Wereld", "English"),
        Word("Reason", "Redenen", "English"),
    )
    fun play() {
        println("What difficulty do you want? (Easy / Hard)")
        var questionNr = readLine()
        var t = 0
        var randomLanguage = false

        if(questionNr == "Easy" || questionNr == "easy"){
            t = 3
        } else if(questionNr == "Hard" || questionNr == "hard"){
            t = 6
            randomLanguage = true
        }
        var count = t
        if (!randomLanguage) {
            println("What language do you want to practice? (French, English)")
            var language = readLine()!!
            if(t == 0){
            count = 5
            t = 5
        }
            words = words.filter { it.language == language }.toMutableList()
        }
        words = words.shuffled().take(t).toMutableList()

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