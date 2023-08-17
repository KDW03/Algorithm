import java.math.BigInteger
import kotlin.math.sqrt

fun main() {
    val br = System.`in`.bufferedReader()
    var n = br.readLine().toInt()
    val sb = StringBuilder()
    while (n-- > 0) {
        val t = br.readLine().toLong()
        val b = BigInteger(t.toString())
        if (t == 0L || t == 1L) {
            sb.append(b.nextProbablePrime()).append("\n")
            continue
        }
        var flag = false
        for (i in 2..sqrt(t.toDouble()).toInt()) {
            if (t % i == 0L) {
                flag = true
                break
            }
        }
        if (flag) {
            sb.append(b.nextProbablePrime())
        } else {
            sb.append(t)
        }
        sb.append("\n")
    }
    println(sb.toString())
}