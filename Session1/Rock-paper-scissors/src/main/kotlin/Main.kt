fun main () {
    val a = arrayOf("Rock", "Paper", "Scissors")
    var randomChoice = a.random()
    var result = "undecided"
    val win = "You win!"
    val lose = "You lose!"
    val draw = "It's a draw!"
    val choice = readLine()

    if (randomChoice == choice?.capitalize()) {
        return println("It's a draw!")
    }
    when(randomChoice){
        "Rock" -> if(choice == "paper"){result = win} else{result = lose}
        "Paper" -> if(choice == "scissors"){result = win} else{result = lose}
        "Scissors" -> if(choice == "rock"){result = win} else{result = lose}
    }

    if (choice == "paper" || choice == "rock" || choice == "scissors") {
        println("You: ${choice?.capitalize()}")
        println("Opponent: ${randomChoice}")
        println(result)
    } else {
        println("please type in: rock, paper or scissors")
    }
}