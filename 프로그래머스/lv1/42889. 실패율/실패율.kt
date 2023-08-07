class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        val challengeUser = IntArray(N + 2)
        val stayUser = IntArray(N + 2)
        
        for (stage in stages) {
            stayUser[stage]++
        }
        
        challengeUser[N + 1] = stayUser[N + 1]
        for (i in N downTo 1) {
            challengeUser[i] = challengeUser[i + 1] + stayUser[i]
        }
        
        return (1..N).map { stage ->
            val failRate = if (challengeUser[stage] == 0) 0.0 else stayUser[stage].toDouble() / challengeUser[stage]
            Pair(stage, failRate)
        }.sortedWith(compareByDescending<Pair<Int, Double>> { it.second }.thenBy { it.first })
         .map { it.first }
         .toIntArray()
    }
}
