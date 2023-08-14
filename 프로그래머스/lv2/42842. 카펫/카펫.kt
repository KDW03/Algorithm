class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var sum = (brown + 4) / 2 
        var multiple = brown + yellow 
        for(i in 1 until sum / 2 + 1) {
            val col = i
            val row = sum - i
            if(col * row == multiple) return intArrayOf(row,col)
        }
        return intArrayOf(0,0)        
    }
}