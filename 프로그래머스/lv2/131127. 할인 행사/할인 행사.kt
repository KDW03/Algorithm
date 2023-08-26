class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = mutableMapOf<String, Int>()

        repeat(discount.size) {
            wantMap.clear()
            repeat(want.size) { wantMap[want[it]] = number[it] }
            var num = 0
            for(i in it until discount.size) {
                val food = discount[i]
                if(!wantMap.containsKey(food)) break
                if(wantMap[food] == 0) break
                wantMap[food] = wantMap[food]!! - 1
                num ++
            }
            if (num == 10) answer ++
        }

        return answer
    }
}