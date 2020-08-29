package machine

import java.util.*
import kotlin.system.exitProcess

val scanner = Scanner(System.`in`)
var water = 400
var milk = 540
var coffeeBeans = 120
var disposableCups = 9
var money = 550

fun main() {
    print("Write action (buy, fill, take, remaining, exit): ")
    val action = scanner.next()
    when(action) {

        "buy" -> buy()
        "fill" -> fill()
        "take" -> take()
        "remaining" -> coffeeMachineHas()
        "exit" -> exitProcess(0)
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
    when(scanner.next()){
        "1" -> {
            if (water >= espressoWater && coffeeBeans >= espressoBeans && disposableCups != 0){
                println("I have enough resources, making you a coffee!\n")
                water -= espressoWater
                coffeeBeans -= espressoBeans
                disposableCups -= 1
                money += espressoCost
            } else if (water < espressoWater){
                println("I have not enough water!\n")
                main()
            } else if (coffeeBeans < espressoBeans){
                println("I have not enough coffee beans!")
                main()
            } else if (disposableCups == 0){
                println("I have not enough disposable cups!")
                main()
            }
        }
        "2" -> {

            if (water >= latteWater && milk > latteMilk  && coffeeBeans >= espressoBeans && disposableCups != 0){
                println("I have enough resources, making you a coffee!\n")
                water -= latteWater
                milk -= latteMilk
                coffeeBeans -= latteBeans
                disposableCups -= 1
                money += latteCost
            } else if (water < latteWater){
                println("I have not enough water!\n")
                main()
            } else if (milk < latteMilk){
                println("I have not enough water!\n")
                main()
            }else if (coffeeBeans < latteBeans){
                println("I have not enough coffee beans!\n")
                main()
            } else if (disposableCups == 0){
                println("I have not enough disposable cups!\n")
                main()
            }
        }
        "3" -> {
            if (water >= cappuccinoWater && milk > cappuccinoMilk  && coffeeBeans >= cappuccinoBeans && disposableCups != 0){
                println("I have enough resources, making you a coffee!\n")
                water -= cappuccinoWater
                milk -= cappuccinoMilk
                coffeeBeans -= cappuccinoBeans
                disposableCups -= 1
                money += cappuccinoCost
            } else if (water < cappuccinoWater){
                println("I have not enough water!\n")
                main()
            } else if (milk < cappuccinoMilk){
                println("I have not enough water!\n")
                main()
            }else if (coffeeBeans < cappuccinoBeans){
                println("I have not enough coffee beans!\n")
                main()
            } else if (disposableCups == 0){
                println("I have not enough disposable cups!\n")
                main()
            }
        }
        "back" -> main()
    }

    main()
}

fun fill(){
    print("\nWrite how many ml of water the coffee machine has: ")
    val hasWater = scanner.nextInt()

    print("\nWrite how many ml of milk the coffee machine has: ")
    val hasMilk = scanner.nextInt()

    print("\nWrite how many disposable cups of coffee do you want to add ")
    val hasCoffeeBeans = scanner.nextInt()

    print("\nWrite how many cups of coffee you will need: ")
    val hasDisposableCups = scanner.nextInt()

    water += hasWater
    milk += hasMilk
    coffeeBeans += hasCoffeeBeans
    disposableCups +=hasDisposableCups

    main()
}

fun take(){
    println("I gave you $$money\n")
    money -= money

    main()
}

fun coffeeMachineHas(){
    println("\nThe coffee machine has:")
    println("$water of water")
    println("$milk of milk")
    println("$coffeeBeans of coffee beans")
    println("$disposableCups of disposable cups")
    println("$money of money\n")

    main()
}
