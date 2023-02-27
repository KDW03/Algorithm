class Solution {
    fun solution(bin1: String, bin2: String): String {
        val tmp = ("0"+(bin1.toLong() + bin2.toLong()).toString()).map{ it.digitToInt() }.toMutableList()
        val sb = StringBuilder()
        for(i in tmp.size -1 downTo 0){
            if(tmp[i] >= 2){
                sb.append(tmp[i] - 2)
                if(i > 0){
                    tmp[i-1]++
                }
            }else{
                sb.append(tmp[i])
            }
        }
        val answer = sb.toString().reversed()
        return if(answer.first() == '0') answer.substring(1) else answer
    }
}