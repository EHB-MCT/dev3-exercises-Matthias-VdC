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
        println("How many questions do you want? (1-10 or type 0 to ignore")
        var questionNr = readLine()!!.toInt()
        println("What language do you want to practice? (French, English)")
        var language = readLine()!!
        var count = questionNr
        if(questionNr == 0){
            count = 5
            questionNr = 5
        }
        words = words.filter{it.language == language}.toMutableList()
        words = words.shuffled().take(questionNr).toMutableList()

        for (i in 0 until questionNr) {
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