class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        survey.forEachIndexed { index, s ->
            var score = 0
            var typeClass = Type.RT

            if (s[0] > s[1]) {
                typeClass = Type.valueOf(s.reversed())
                score = 8 - choices[index]
            } else {
                typeClass = Type.valueOf(s)
                score = choices[index]
            }

            if (score <= 3) {
                typeClass.firstScore += (4 - score)
            } else if (score >= 5) {
                typeClass.secondScore += (score - 4)
            }
        }
        return Type.values().map { if (it.firstScore >= it.secondScore) it.name[0] else it.name[1] }.joinToString("")
    }
}


enum class Type(var firstScore: Int = 0, var secondScore: Int = 0) {
    RT, CF, JM, AN
}

