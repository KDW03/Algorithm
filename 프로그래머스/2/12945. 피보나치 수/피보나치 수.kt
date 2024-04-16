class Solution {
    fun solution(n: Int): Int {
    val MOD = 1234567
    if (n == 2) return 1

    var a = 0L  
    var b = 1L  
    var c = 0L

    for (i in 2..n) {
        c = (a + b) % MOD  
        a = b
        b = c
    }

    return c.toInt()
}

}