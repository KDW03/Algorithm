class Solution {
   // 시간복잡도 : arr1 x * arr2 x * arr2 y
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray> {
        val result = Array(arr1.size) { IntArray(arr2[0].size) { 0 } }

        for (i in arr1.indices) {
            for (j in arr2[0].indices) {
                // arr2의 행, arr1의 열에 대해서 반복합니다.
                for (k in arr2.indices) {
                    result[i][j] += arr1[i][k] * arr2[k][j]
                }
            }
        }

        return result
    }
}