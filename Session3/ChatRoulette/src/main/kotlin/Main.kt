fun main(){
    val people = arrayOf(Student("Sam"), Comedian("Dries"), Teacher("Dirk"), Chatbot("Clippy"))
    val chatBuddy = people.random()

    chatBuddy.introduce()
    chatBuddy.talk()
}