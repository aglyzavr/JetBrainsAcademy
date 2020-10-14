package machine

import java.util.*
import kotlin.system.exitProcess

class CoffeeMachine {

     object CoffeeSupplies {
        var water = 400
        var milk = 540
        var coffeeBeans = 120
        var disposableCups = 9
        var money = 550
         var count = -1

    }

    companion object{
        var currentState: CurrentState = CurrentState.EXIT
    }

    object FillCoffeeMachine {
        val fill: Array<String> = arrayOf(
                "Write how many ml of milk do you want to add: ",
                "Write how many grams of coffee beans do you want to add: ",
                "Write how many disposable cups of coffee do you want to add: "
        )
    }

    enum class CoffeeRecipe(val water: Int, val milk: Int, val beans: Int, val cost: Int) {
        ESPRESSO(250, 0,16, 4),
        LATTE(350, 75, 20, 7),
        CAPPUCCINO(200, 100, 12, 6),

    }

    enum class CurrentState(val dialog: String) {
        START("Write action (buy, fill, take, remaining, exit): "),
        BUY("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: "),
        FILL("Write how many ml of water do you want to add: "),
        TAKE("I gave you $"),
        REMAINING("\nThe coffee machine has:"),
        EXIT("");

        companion object {
            fun getState(state: String): CurrentState {
                for (enum in values()) if (enum.toString() == state) return enum
                return START
            }
        }
    }

    fun start() {
        reset()
        run("START")
    }

    fun on(): Boolean {
        return currentState != CurrentState.EXIT
    }

    private fun reset() {
        currentState = CurrentState.START
    }

    private fun coffeeMachineHas(){
        println("${CoffeeSupplies.water} of water")
        println("${CoffeeSupplies.milk} of milk")
        println("${CoffeeSupplies.coffeeBeans} of coffee beans")
        println("${CoffeeSupplies.disposableCups} of disposable cups")
        println("${CoffeeSupplies.money} of money\n")

        main()
    }

    private fun checkNum(strPassed: String): Boolean {
        return strPassed.toIntOrNull() != null
    }

    private fun getCoffee(drink: CoffeeRecipe) {
        when {
            CoffeeSupplies.disposableCups <= 0 -> println("Sorry, not enough cups!")
            drink.water > CoffeeSupplies.water -> println("Sorry, not enough water!")
            drink.milk > CoffeeSupplies.milk -> println("Sorry, not enough milk!")
            drink.beans > CoffeeSupplies.coffeeBeans -> println("Sorry, not enough coffee beans!")
            else -> {
                CoffeeSupplies.water -= drink.water
                CoffeeSupplies.milk -= drink.milk
                CoffeeSupplies.coffeeBeans -= drink.beans
                CoffeeSupplies.disposableCups--
                CoffeeSupplies.money += drink.cost
                println("I have enough resources, making you a coffee!")
            }
        }
    }

    fun run(string: String) {
        if (on()) {
            if (currentState == CurrentState.START) currentState = CurrentState.getState(string)
            when (currentState) {
                CurrentState.START -> {
                    print(currentState.dialog)
                    return
                }
                CurrentState.BUY -> {
                    when (string) {
                        "1" -> {
                            getCoffee(CoffeeRecipe.ESPRESSO)
                            reset()
                        }
                        "2" -> {
                            getCoffee(CoffeeRecipe.LATTE)
                            reset()
                        }
                        "3" -> {
                            getCoffee(CoffeeRecipe.CAPPUCCINO)
                            reset()
                        }
                        "BACK" -> reset()
                    }
                }
                CurrentState.FILL -> {
                    if (CoffeeSupplies.count > -1) {
                        if (checkNum(string)) {
                            when (CoffeeSupplies.count) {
                                0 -> CoffeeSupplies.water += string.toInt()
                                1 -> CoffeeSupplies.milk += string.toInt()
                                2 -> CoffeeSupplies.coffeeBeans += string.toInt()
                                3 -> {
                                    CoffeeSupplies.disposableCups += string.toInt()
                                    CoffeeSupplies.count = -2
                                    reset()
                                }
                            }
                        } else CoffeeSupplies.count--
                    }
                    CoffeeSupplies.count++
                }
                CurrentState.TAKE -> {
                    println(currentState.dialog + CoffeeSupplies.money)
                    CoffeeSupplies.money = 0
                    reset()
                }
                CurrentState.REMAINING -> {
                    println(currentState.dialog)
                    coffeeMachineHas()
                    reset()
                }
                CurrentState.EXIT -> return exitProcess(0)
            }
            if (CoffeeSupplies.count <= 0) {
                println(currentState.dialog)
            } else print(FillCoffeeMachine.fill[CoffeeSupplies.count - 1])
        }
    }
}

fun getString(): String {
    val scanner = Scanner(System.`in`)
    return (scanner.nextLine().toUpperCase())
}

fun main() {
    val coffee = CoffeeMachine()
    coffee.start()
    while (coffee.on()) coffee.run(getString())
}