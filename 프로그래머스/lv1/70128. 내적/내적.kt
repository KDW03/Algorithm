class Solution {
    fun solution(a: IntArray, b: IntArray): Int = a.foldIndexed(0) { index, acc , _ -> 
        acc + (a[index] * b[index])
    }
}