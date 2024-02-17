class Solution {
    fun solution(number: String, k: Int): String {
        var windowSize = k
        val ans = StringBuilder()
        var count = 0
        var i = 0
        outer@while(i in number.indices) {
            val now = number[i].digitToInt()
            // now 다음부터 윈도우 size만큼 확인
            for(j in i + 1 .. i + windowSize) {
                // 윈도우내에 더 큰 숫자가 있다면
                // 윈도우 사이즈 줄이고 now 제거
                if(number[j].digitToInt() > now) {
                    windowSize -= (j - i)
                    i += (j - i)
                    continue@outer
                }
            }
            // 제거 안됐다면 정답에 포함
            ans.append(now)
            count++
            i++
            if(count >= number.length - k) break@outer
        }
        
        return ans.toString()
    }
}