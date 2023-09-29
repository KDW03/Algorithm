class Solution {
    fun solution(strArr: Array<String>): Int {
        return strArr.toList().groupingBy{ it.length }.eachCount().values.maxOf{ it }
    }
}