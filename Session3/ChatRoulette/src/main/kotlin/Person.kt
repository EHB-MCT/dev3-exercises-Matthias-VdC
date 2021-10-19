open class Person(protected open val name: String?) {
    open fun introduce() {
        println("Hello my name is $name")
    }
    open fun talk(){

    }
}