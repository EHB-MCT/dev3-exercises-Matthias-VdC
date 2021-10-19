class Comedian(override val name: String?):Person(name), ChatPartner {
    override fun talk(){
        tellJoke()
    }
    private fun tellJoke(){
        println("Time flies like an arrow. Fruit flies like a banana.")
    }
}