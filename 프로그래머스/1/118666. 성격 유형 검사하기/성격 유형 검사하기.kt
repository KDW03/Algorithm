class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        val answer = arrayOf("RT", "CF", "JM", "AN").map {
            it.toCharArray().sorted()
        }

        val map : HashMap<Char,Int> = hashMapOf()
        survey.forEachIndexed { i , v ->
            val choice = choices[i]
            if(choice <= 3) {
                map[v[0]] = map.getOrDefault(v[0],0) + (4 - choice)
            }

            if(choice >= 5) {
                map[v[1]] = map.getOrDefault(v[1],0) + (choice - 4)
            }
        }

        return answer.map {
            val a = it[0]
            val b = it[1]

            val aScore = map.getOrDefault(a,0)
            val bScore = map.getOrDefault(b,0)

            if(aScore >= bScore) {
                it[0]
            }else{
                it[1]
            }
        }.joinToString("")
    }
}