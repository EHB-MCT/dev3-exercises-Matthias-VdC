import java.sql.*
import java.util.*


fun installer(){
    Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance()
    val connectionProps = Properties()
    connectionProps["user"] = Credentials().user
    connectionProps["password"] = Credentials().pass

// Create the connection: this will allow us to run queries on it later
    val connection =  DriverManager.getConnection(
        "jdbc:" + "mysql" + "://" +
                Credentials().hostName +
                ":" + "3306" + "/" +
                Credentials().user,
        connectionProps)

    //1st exercise
    var statement = connection.prepareStatement("SELECT DISTINCT city_b FROM trains")
    var result = statement.executeQuery()
    println("please choose the following destinations:")
    while(result.next()) {
        println(result.getString("city_b"))
    }

    //2nd exercise
    val chooseDestination = readLine()

    statement = connection.prepareStatement("SELECT * FROM trains WHERE city_b='$chooseDestination' AND CURRENT_DATE = DATE(departure) ORDER BY departure ASC limit 3")
    result = statement.executeQuery()
    while(result.next()) {
        println(result.getString("train_name") + " - Platform: " + result.getString("platform") +  " - Departure time: " + result.getString("departure"))
    }
}

fun main(){
    installer()
}