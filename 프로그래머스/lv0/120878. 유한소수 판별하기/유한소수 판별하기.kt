class Solution {
    fun solution(a: Int, b: Int): Int {
        var answer: Int = 0
        var cd = gcd(a,b)
        var tmp = if(cd == 1) b else b / cd
        while(tmp % 5 == 0 && tmp >= 5) tmp /= 5 
        while(tmp % 2 == 0 && tmp >= 2) tmp /= 2
        return if(tmp == 1) 1 else 2
    }
    
    fun gcd(a : Int, b : Int) : Int{
        if(b == 0) return a
        return gcd(b, a % b)
    }
}