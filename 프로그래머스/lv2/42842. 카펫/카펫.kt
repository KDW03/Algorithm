class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        val sum = brown + yellow
        val tmp = brown/2
        var row = (tmp / 2) + (tmp % 2)
        var column = tmp / 2
        while(true){
            if((row+1) * (column+1) == sum) break
            row++
            column--
        }
        return intArrayOf(row+1,column+1)
    }
}
