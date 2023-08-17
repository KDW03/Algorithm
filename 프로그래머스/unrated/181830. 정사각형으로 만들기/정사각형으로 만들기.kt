class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val rowSize = arr.size
        val colSize = arr[0].size
        val size = maxOf(rowSize,colSize)
        
        val answer : Array<IntArray> = Array(size){ IntArray(size) }
        for(i in 0 until rowSize){
            for(j in 0 until colSize){
                answer[i][j] = arr[i][j]
            }
        }
        return answer
    }
}