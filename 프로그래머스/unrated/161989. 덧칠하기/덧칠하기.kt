class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {

        var value = section.first() + m - 1
        var answer = 1
        var start = 0

        while (true) {
            
            val idx = section.binarySearch(value, start).let {
                if (it < 0) -it - 1 else it + 1
            }
         
            if (idx >= section.size) {
                break
            } else {
                value = section[idx] + m - 1
                start = idx
                answer++
            }
        }
        
        return answer

    }
}