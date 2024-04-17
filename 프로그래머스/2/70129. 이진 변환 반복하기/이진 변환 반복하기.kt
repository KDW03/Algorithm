class Solution {
    fun solution(s: String): IntArray {
        var now = s
        var count = 0
        var removeZero = 0
        while(now != "1") {
            var ft = now.filter { it != '0' }
            removeZero += now.length - ft.length
            now = (ft.length).toString(2)
            count++
        }
        
        return intArrayOf(count,removeZero)
    }
}
