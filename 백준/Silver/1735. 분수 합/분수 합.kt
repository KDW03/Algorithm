fun main() {
    val br = System.`in`.bufferedReader()

    val (a, b) = br.readLine().split(" ").map { it.toInt() }
    val (c, d) = br.readLine().split(" ").map { it.toInt() }

    val top = a * d + c * b
    val under = b * d

    if (top % under == 0) {
        println("${top / under} 1")
    } else {
        val gcd = gcd(top, under)
        println("${top / gcd} ${under / gcd}")
    }
}
fun gcd(top: Int, under: Int): Int {

    if (under == 0) return top
    return gcd(under, top % under)
}
