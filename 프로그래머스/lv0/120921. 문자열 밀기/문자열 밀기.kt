class Solution {
    fun solution(A: String, B: String): Int {
        if (A==B){
            return 0
        }
        val firstB = B.first()
        val matchIndexArray = arrayListOf<Int>()
        for ((i,char) in A.withIndex()){
            if (char == firstB) matchIndexArray.add(i)
        }
        for (i in matchIndexArray.reversed()) {
            val subString = A.substring(i)+A.substring(0, i)
            println(subString)
            if (B == subString) {
                return A.length-i
            }
        }
        return -1
    }
}