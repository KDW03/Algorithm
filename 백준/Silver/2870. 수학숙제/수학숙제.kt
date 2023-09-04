import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val list = mutableListOf<BigInteger>()
    repeat(n) {
        val str = br.readLine()
        var sb = StringBuilder()
        str.forEach {
            if (it.isDigit()) sb.append(it)
            else {
                if (sb.isNotEmpty()) {
                    val b = BigInteger(sb.toString())
                    list.add(b)
                    sb = StringBuilder()
                }
            }
        }
        if (sb.isNotEmpty()) {
            val b = BigInteger(sb.toString())
            list.add(b)
        }
    }
    
    list.sorted().forEach {
        println(it)
    }
}