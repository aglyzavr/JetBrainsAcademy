package machine

import java.util.*

fun main() {
    print("Write how many cups of coffee you will need: ")
    val scanner = Scanner(System.`in`)
    val water = 200
    val milk = 50
    val coffeBeans = 15
    val cupsOfCoffeeNeeds = scanner.nextInt()

    println("For $cupsOfCoffeeNeeds cups of coffee you will need:\n")
    println("${cupsOfCoffeeNeeds*water} ml of water")
    println("${cupsOfCoffeeNeeds*milk} ml of milk")
    println("${cupsOfCoffeeNeeds*coffeBeans} g of coffee beans")
}
