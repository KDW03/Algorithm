class Solution {
    fun solution(a: Int, b: Int): String {
        
        val arr = intArrayOf(31,29,31,30,31,30,31,31,30,31,30,31)
        
        val month = a - 1
        var day = b - 1
        for(i in 0 until month) day += arr[i]
        
        val t = arrayOf("FRI","SAT","SUN","MON","TUE","WED","THU")
        return t[day % 7]
    }
}