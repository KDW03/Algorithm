class Solution {
    fun solution(arr: IntArray): Int {
        var pre = arr[0]
        for(i in 1 until arr.size) pre =  pre * arr[i] / gcd(arr[i], pre) 
        return pre
    }
    
    fun gcd(a : Int, b : Int) : Int {
        if(b == 0) return a 
        
        return gcd(b, a % b)
    }
}