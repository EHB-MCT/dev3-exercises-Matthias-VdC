class Student(override val name: String?):Person(name), ChatPartner {
    override fun talk(){
        gossip()
    }
    private fun gossip(){
        println("Hehe, I passed my last test")
    }
}