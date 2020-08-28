package machine

import java.util.*

val scanner = Scanner(System.`in`)
var water = 400
var milk = 540
var coffeeBeans = 120
var disposableCups = 9
var money = 550

fun main() {
    coffeeMachineHas()
    print("Write action (buy, fill, take): ")
    val action = scanner.next()
    when(action) {

        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
    }
}

fun buy(){

    val espressoWater = 250
    val espressoBeans = 16
    val espressoCost = 4

    val latteWater = 350
    val latteMilk = 75
    val latteBeans = 20
    val latteCost = 7

    val cappuccinoWater = 200
    val cappuccinoMilk = 100
    val cappuccinoBeans = 12
    val cappuccinoCost = 6

    print("\nWhat do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ")
    when(scanner.nextInt()){
        1 -> {
            println("The coffee machine has:")
            println("${water - espressoWater} of water")
            println("${milk} of milk")
            println("${coffeeBeans - espressoBeans} of coffee beans")
            println("${disposableCups - 1} of disposable cups")
            println("${money + espressoCost} of money")
        }
        2 -> {
            println("The coffee machine has:")
            println("${water - latteWater} of water")
            println("${milk - latteMilk} of milk")
            println("${coffeeBeans - latteBeans} of coffee beans")
            println("${disposableCups - 1} of disposable cups")
            println("${money + latteCost} of money")
        }
        3 -> {
            println("The coffee machine has:")
            println("${water - cappuccinoWater} of water")
            println("${milk - cappuccinoMilk} of milk")
            println("${coffeeBeans - cappuccinoBeans} of coffee beans")
            println("${disposableCups - 1} of disposable cups")
            println("${money + cappuccinoCost} of money")
        }
    }
}

fun fill(){
    print("Write how many ml of water the coffee machine has: ")
    val hasWater = scanner.nextInt()

    print("\nWrite how many ml of milk the coffee machine has: ")
    val hasMilk = scanner.nextInt()

    print("\nWrite how many disposable cups of coffee do you want to add ")
    val hasCoffeeBeans = scanner.nextInt()

    print("\nWrite how many cups of coffee you will need: ")
    val hasDisposableCups = scanner.nextInt()

    println("\n${water + hasWater} of water")
    println("${milk + hasMilk} of milk")
    println("${coffeeBeans + hasCoffeeBeans} of coffee beans")
    println("${disposableCups + hasDisposableCups} of disposable cups")
    println("$money of money")
}

fun take(){
    println("I gave you $$money")
    println("\n$water of water")
    println("$milk of milk")
    println("$coffeeBeans of coffee beans")
    println("$disposableCups of disposable cups")
    println("${money - money} of money")
}

fun coffeeMachineHas(){
    println("The coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$coffeeBeans of coffee beans")
    println("$disposableCups of disposable cups")
    println("$money of money\n")
}
