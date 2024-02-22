class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {


        val map = players.mapIndexed { i , v ->
            v to i
        }.toMap().toMutableMap()

        val answer = players


        fun swap(callingIdx : Int) {
            if(callingIdx == 0) return
            val tmp = answer[callingIdx - 1]
            answer[callingIdx - 1] = answer[callingIdx]
            answer[callingIdx] = tmp
            // map 순서 변경
            map[answer[callingIdx]] = map[answer[callingIdx]]!! + 1
            map[answer[callingIdx - 1]] = map[answer[callingIdx - 1]]!! - 1
        }


        callings.forEach {
            swap(map.getOrDefault(it,0))
        }


        return answer
    }
}