fun main(){
    println("You are stuck in a tower, the only way to escape is by going up...")
    challengeOne()
    challengeTwo()
}

fun gameOver(){
    return println("You have failed. Game Over!")
}

fun succes(){
    return println("Your answer is correct")
    return println("You may proceed to the next floor")
}

fun floorCount(i:String){
    return println("floor $i")
}

fun diceRoll():Int{
    return (0..6).random()
}

fun challengeOne(){
    floorCount("1")
    println("Solve this riddle to proceed: Feed me and I will live, give me a drink and I will die. What am I?")

    var answer = readLine()

    when(answer){
        "fire" -> succes()
        else -> {
            gameOver()
        }
    }
}


fun challengeTwo (){
    floorCount("2")
    println("Guess what number the dice will fall on, and you may pass.")

    val answer = readLine()
    val roll = diceRoll()

    println("The dice has fallen on $roll")
    when(answer) {
        "1", "2", "3" -> if (roll == 1 || roll == 2 || roll == 3) {
            succes()
        } else {
            gameOver()
        }
        else -> if (roll == 4 || roll == 5 || roll == 6) {
            succes()
        } else {
            gameOver()
        }
    }
}