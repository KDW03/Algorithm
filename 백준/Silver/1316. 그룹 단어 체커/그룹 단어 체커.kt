import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var result = 0
    for(j in 0 until n){
        val temp = br.readLine()
        if (temp.length == 1) {
            result++
            continue
        }
        for (i in 1 until temp.length) {
            if (temp[i] != temp[i - 1] && (temp.indexOfFirst { it == temp[i] } < i))
                break
            if (i == temp.length - 1)
                result++
        }
    }
    println(result)
}
