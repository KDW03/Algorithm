import kotlin.math.sqrt

lateinit var arr : BooleanArray

fun main() {
    val br = System.`in`.bufferedReader()
    val (m,n) = br.readLine().split(' ').map { it.toInt() }
    createDecimalTable(n)
    for (i in m .. n){
        if (arr[i]) println(i)
    }
}

fun isDecimal(number: Int): Boolean {
    val sqrtNum = sqrt(number.toDouble()).toInt()
    for (i in 3 .. sqrtNum step 2){
        if (arr[i] && number%i == 0)
            return false
    }
    return true
}

fun createDecimalTable(m : Int) {
    arr = BooleanArray(m+1)
    arr[2] = true
    for (i in 3 until arr.size step 2){
        if (isDecimal(i)){
            arr[i] = true
        }
    }
}