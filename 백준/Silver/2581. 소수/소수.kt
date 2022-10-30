import kotlin.math.sqrt
lateinit var arr : BooleanArray

fun main() {
    val br = System.`in`.bufferedReader()
    val m = br.readLine().toInt()
    val n = br.readLine().toInt()

    if (n == 1){
        print(-1)
    }else{
        val answerArr = ArrayList<Int>()
        createDecimalTable(n)
        for (i in m .. n){
            if (arr[i]) answerArr.add(i)
        }
        if (answerArr.size == 0){
            println(-1)
        }else{
            println(answerArr.sum())
            println(answerArr[0])
        }
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

fun createDecimalTable(n : Int) {
    arr = BooleanArray(n+1)
    arr[2] = true
    for (i in 3 until arr.size step 2){
        if (isDecimal(i)){
            arr[i] = true
        }
    }
}


