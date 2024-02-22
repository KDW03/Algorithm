class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        
        var answer = 0
        
        val sorted = data.sortedWith(
            // col - 1 번째로 오름차순 정렬
            compareBy<IntArray> { it[col - 1] }.thenByDescending { it[0] }
        ) 
        
        // row_begiht - 1 부터 row_end - 1 까지
        for(i in row_begin - 1 .. row_end - 1) {
            val sum = sorted[i].sumOf { it % (i + 1) }
            answer = answer xor sum
        }
        
        return answer
    }
}