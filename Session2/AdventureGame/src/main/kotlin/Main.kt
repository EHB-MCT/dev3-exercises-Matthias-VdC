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

    var answer = readline()

    when(answer){}
}