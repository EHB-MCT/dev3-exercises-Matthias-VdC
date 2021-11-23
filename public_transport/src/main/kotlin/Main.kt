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
                "dt5.ehb.be" +
                ":" + "3306" + "/" +
                Credentials().user,
        connectionProps)
}

fun main(){
    installer()
}