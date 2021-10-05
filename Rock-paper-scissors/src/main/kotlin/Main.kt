fun main () {
    val a = arrayOf("Rock", "Paper", "Scissors")
    var randomChoice = a.random()
    var result = "undecided"
    var score = 0
    val win = "You win!"
    val lose = "You lose!"
    val draw = "It's a draw!"
    val choice = readLine()

    if (choice == "rock") {
        if (randomChoice == "Paper") {
            result = lose
            score -= 1
        }
        if (randomChoice == "Scissors") {
            result = win
            score += 1
        }
    }
    if (choice == "paper") {
        if (randomChoice == "Rock") {
            result = win
            score += 1
        }
        if (randomChoice == "Scissors") {
            result = lose
            score -= 1
        }
    }
    if (choice == "scissors") {
        if (randomChoice == "Rock") {
            result = lose
            score -= 1
        }
        if (randomChoice == "Paper") {
            result = win
            score += 1
        }
    }
    if (randomChoice == choice?.capitalize()) {
        result = draw
    }
    if (choice == "paper" || choice == "rock" || choice == "scissors") {
        println("You: ${choice?.capitalize()}")
        println("Opponent: ${randomChoice}")
        println(result)
    } else {
        println("please type in: rock, paper or scissors")
    }
}