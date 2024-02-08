class Solution {
    fun solution(topping: IntArray): Int {

        val aCountMap : MutableMap<Int,Int> = hashMapOf()
        val bCountMap = topping.toList().groupingBy{ it }.eachCount().toMutableMap()
        var answer = 0

        // n 
        for(i in 0 until topping.size - 1) {
            val top = topping[i]
            aCountMap[top] = aCountMap.getOrDefault(top,0) + 1
            val bNew = bCountMap[top]!! - 1
            if(bNew == 0) bCountMap.remove(top) else bCountMap[top] = bNew
            if(aCountMap.size == bCountMap.size) answer++
        }

        return answer
    }
}