class Solution {
    fun solution(elements: IntArray): Int {
        val n = elements.size
        val list = elements + elements
        val set: HashSet<Int> = hashSetOf()


        for (t in 1 .. n) {
            for (i in 0 until n) {
                val sum = list.slice(i until i + t).sum()
                set.add(sum)
            }
        }
        
        return set.size
    }
}

