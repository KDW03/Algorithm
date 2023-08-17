class Solution {
    fun solution(arr: Array<IntArray>): Array<IntArray> {
        val rowSize = arr.size
        val colSize = arr[0].size
        return if (colSize > rowSize) {
            var t = arr
            repeat(colSize - rowSize){
                t += IntArray(colSize)
            }
            t
        } else if (rowSize > colSize) {
            arr.map {
                IntArray(rowSize) { idx -> if (colSize > idx) it[idx] else 0 }
            }.toTypedArray()
        } else {
            arr
        }
    }
}