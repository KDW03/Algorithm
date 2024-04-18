class Solution {
    fun solution(arr: IntArray): Int {
        return arr.reduce { lcm, element -> lcm(lcm, element) }
    }
}

fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val t = y
        y = x % y
        x = t
    }
    return x
}

fun lcm(a: Int, b: Int): Int {
    return a / gcd(a, b) * b
}