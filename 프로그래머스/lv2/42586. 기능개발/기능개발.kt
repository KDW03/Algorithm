class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = ArrayList<Int>()
        val requireDay = progresses.mapIndexed { index, i ->
            val remain = 100 - i
            val speed = speeds[index]
            var day = if (remain % speed != 0) 1 else 0
            day += (remain / speed)
            day
        }
        var max = requireDay[0]
        var workCount = 0
        requireDay.forEach {
            if (it > max){
                max = it
                answer.add(workCount)
                workCount = 1
            }else{
                workCount++
            }
        }
        answer.add(workCount)
        return answer.toIntArray()
    }
}
