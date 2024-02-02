class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var aRank = a
        var bRank = b
        var count = 0
        while(aRank != bRank) {
            aRank = (aRank + 1) / 2
            bRank = (bRank + 1) / 2
            count++
        }
                    
        return count
    }
}