import kotlin.math.sqrt

val arr = BooleanArray(1001)

fun main() {
    val br = System.`in`.bufferedReader()
    br.readLine()
    var result = 0
    createDecimalTable()
    for (number in br.readLine().split(' ').map { it.toInt() }){
        if (arr[number]) result++
    }
    print(result)
}

fun isDecimal(number: Int): Boolean {
    val sqrtNum = sqrt(number.toDouble()).toInt()
    for (i in 3 .. sqrtNum step 2){
        if (arr[i] && number%i == 0)
            return false
    }
    return true
}

fun createDecimalTable() {
    arr[2] = true
    for (i in 3 until arr.size step 2){
        if (isDecimal(i)){
            arr[i] = true
        }
    }
}