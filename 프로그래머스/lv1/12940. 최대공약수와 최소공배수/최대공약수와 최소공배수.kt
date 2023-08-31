class Solution {
    fun solution(n: Int, m: Int): IntArray {
        val gcd = gcd(n,m)
        
        return intArrayOf(gcd , n * m / gcd)
    }
    
    fun gcd(a : Int, b : Int) : Int {
        if(b == 0) return a
        
        return gcd(b, a % b)
    }
}