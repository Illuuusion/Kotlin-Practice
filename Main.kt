import kotlin.math.pow
import kotlin.math.absoluteValue

fun main(){
    var key = false
    while(!key) {
        val eps = inputAccuracy()
        if (eps != null) {
            println(amount(eps))
            key = true
        }
    }
}

fun inputAccuracy(): Double? {
    var rightInput = false
    var number: Double? = null
    while (!rightInput){
        number = readlnOrNull()?.toDoubleOrNull()
        if (number != null) {
            rightInput = true
        }
        else{
            println("Error")
            println("Input a float accuracy")
        }
    }
    return number
}

fun factor(n: Int): Int{
    if (n == 0 || n == 1)
        return 1
    return n * factor(n - 1)
}

fun numericalSeries(n: Int): Double{
    return ((-1.0).pow(n))/factor(n)
}

fun amount(eps: Double): Double{
    var n: Int = 0
    var amountCurrent = 0.0
    var amountPrevious: Double
    var amount= 0.0
    do{
        amountPrevious = amountCurrent
        amountCurrent = numericalSeries(n)
        amount += amountCurrent
        n += 1
    }while ((amountCurrent - amountPrevious).absoluteValue > eps)
    return amount
}