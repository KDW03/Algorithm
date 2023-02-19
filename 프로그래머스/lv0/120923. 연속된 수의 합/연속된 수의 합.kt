class Solution{
    fun solution(num: Int, total: Int) : IntArray {
        val answer = IntArray(num)
        var start = 1+((total - (num*(num+1))/2) / num) 
        for(i in 0 until num) {
            answer[i] = start++
        }
        return answer
    }
}


