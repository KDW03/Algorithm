class Solution {
    fun solution(N: Int, stages: IntArray): IntArray = IntArray(N).mapIndexed { i,v ->
        val stage = i + 1

        var challengeUser = 0f
        var stayUser = 0f

        stages.forEach { userStayStage ->
            if(userStayStage >= stage) challengeUser++
            if(userStayStage == stage) stayUser++
        }
        var failRate = 0f
        if(challengeUser != 0f) failRate = stayUser/challengeUser
        Pair(stage,failRate)
    }.sortedBy{
        it.first
    }.sortedByDescending {
        it.second
    }.map{
        it.first
    }.toIntArray()
}