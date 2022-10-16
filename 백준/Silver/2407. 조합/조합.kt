import java.math.BigInteger

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    if (n == m){
        println(1)
        return
    }else{
        var result = BigInteger("1")
        for (i in 0 until  m){
            val temp = BigInteger((n-i).toString())
            val temp2 = BigInteger((i+1).toString())
            result = result.multiply(temp).divide(temp2)
        }
        println(result.toString())
    }
}