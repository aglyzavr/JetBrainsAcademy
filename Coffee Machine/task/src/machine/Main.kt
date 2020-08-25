package machine

import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val water = 200
    val milk = 50
    val coffeeBeans = 15
    var minCups = 0

    print("Write how many ml of water the coffee machine has: ")
    val hasWater = scanner.nextInt()

    print("\nWrite how many ml of milk the coffee machine has: ")
    val hasMilk = scanner.nextInt()

    print("\nWrite how many grams of coffee beans the coffee machine has: ")
    val hasCoffeeBeans = scanner.nextInt()

    print("\nWrite how many cups of coffee you will need: ")
    val cupsOfCoffeeNeeds = scanner.nextInt()

    val minWater = hasWater/water
    val minMilk = hasMilk/milk
    val minCoffeeBeans = hasCoffeeBeans/coffeeBeans

    minCups += if ((minMilk in minCoffeeBeans..minWater) || (minWater in minCoffeeBeans..minMilk)) {
        minCoffeeBeans
    } else if ((minCoffeeBeans in minMilk..minWater) || (minWater in minMilk..minCoffeeBeans)){
        minMilk
    } else {
        minWater
    }

    when {
        minCups == cupsOfCoffeeNeeds -> {
            println("Yes, I can make that amount of coffee")
        }
        minCups < cupsOfCoffeeNeeds && cupsOfCoffeeNeeds != 0 -> {
            println("No, I can make only $minCups cups of coffee")
        }
        minCups > cupsOfCoffeeNeeds && cupsOfCoffeeNeeds != 0 -> {
            println("Yes, I can make that amount of coffee (and even " +
                    "${cupsOfCoffeeNeeds - minCups} more than that)")
        }
        cupsOfCoffeeNeeds <= 0 -> {
            println("Yes, I can make that amount of coffee (and even " +
                    "1 more than that)")
        }
    }
}
