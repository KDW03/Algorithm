class Solution {
    fun solution(arr1: Array<IntArray>, arr2: Array<IntArray>): Array<IntArray>  = arr1.mapIndexed { x, arr ->
        arr.mapIndexed { y , v ->
            v + arr2[x][y]
        }.toIntArray()
    }.toTypedArray()
}