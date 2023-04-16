import java.util.*

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val map: HashMap<Char, Int> = hashMapOf()
        val str = "RTCFJMAN"
        for (i in str) {
            map[i] = 0
        }
        for ((i, s) in survey.withIndex()) {
            val score = choices[i]
            if (score == 4) continue
            if (score <= 3) {
                map[s[0]] = map[s[0]]!! + (4 - score)
            } else {
                map[s[1]] = map[s[1]]!! + (score - 4)
            }
        }
        for (i in str.indices step 2) {
            val first = str[i]
            val second = str[i + 1]
            answer += if (map[first]!! >= map[second]!!) {
                first
            } else {
                second
            }
        }
        return answer
    }
}