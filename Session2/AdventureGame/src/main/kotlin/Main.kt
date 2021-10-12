fun main(){
    println("You are stuck in a tower, the only way to escape is by going up...")
    challengeOne()
}

fun gameOver(){
    println("You have failed. Game Over!")
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
        "fire" -> {
            succes()
            challengeTwo()
        }
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
            challengeThree()
        } else {
            gameOver()
        }
        "4", "5", "6" -> if (roll == 4 || roll == 5 || roll == 6) {
            succes()
            challengeThree()
        } else {
            gameOver()
        }
    }
}

fun challengeThree(){
    floorCount("3")
    println("You arrive before a giant rat who seems hostile. You see 3 items sprawled in front of you on the floor.")
    println("Which item do you pick?")
    println("1. The whip")
    println("2. The bow")
    println("3. An axe")
    println("Type in the number of what weapon you choose.")

    val answer = readLine()

    when(answer){
        "1" -> {
            println("The rat screams at you but cowers back in fear. It seems to have been whipped before.")
            succes()
            challengeFour()
        }
        "2" -> {
            println("You take the bow and the rat charges at you.")
            println("You don't have any arrows and end up getting eaten by the rat")
            gameOver()
            challengeFour()
        }
        "3" -> {
            println("You take the axe and charge at the rat.")
            println("You stab it with the axe and wound it.")
            println("The rat screams but is even further enraged.")
            println("He bites you and you black out.")
            gameOver()
            challengeFour()
        }
    }
}