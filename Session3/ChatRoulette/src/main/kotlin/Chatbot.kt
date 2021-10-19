class Chatbot(private val name: String?) :ChatPartner {
    override fun talk(){
        println("Beep Boop!")
    }
    override fun introduce(){
        println("Hey, my name is $name")
    }
}