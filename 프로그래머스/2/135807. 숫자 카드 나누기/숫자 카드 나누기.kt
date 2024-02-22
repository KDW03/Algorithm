class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        val ans = ArrayList<Int>()
        
        var aM = 0
        var bM = 0
        
        var preA = arrayA[0]
        for(i in 1 until arrayA.size)  {
            val num = arrayA[i]
            preA = gcd(preA,num)
        }
        
        var preB = arrayB[0]
        for(i in 1 until arrayB.size)  {
            val num = arrayB[i]
            preB = gcd(preB,num)
        }
        
        
        // true라면 preB는 x 
        if(!arrayA.any { it % preB == 0 }) {
            ans.add(preB)
        }
        
        
        // true라면 preA는 x
        if(!arrayB.any { it % preA == 0 }) {
            ans.add(preA)
        }
        
        
        return ans.maxOrNull() ?: 0
    }
    
    
    fun gcd(a : Int, b : Int) : Int {
        return if(b == 0) a
        else gcd(b,a % b)
    }
}