class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {

        val answer = Array(arr1.size){ IntArray(arr2[0].size) }

        for(i in arr1.indices){
            for(j in arr2[0].indices) {
                for(k in arr1[0].indices){
                    val sum = arr1[i][k] * arr2[k][j]
                    answer[i][j] += sum
                }
            }
        }

        return answer
    }
}


