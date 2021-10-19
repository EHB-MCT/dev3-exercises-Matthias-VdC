class Teacher (override val name: String?):Person(name), ChatPartner {
    override fun talk(){
        funFact()
    }
    private fun funFact(){
        println("The severed head of a sea slug can grow a whole new body.")
    }
}