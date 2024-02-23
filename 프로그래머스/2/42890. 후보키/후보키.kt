class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        val rowsSize = relation.size
        val cols = (0 until relation[0].size).toList()
        val answerArr = ArrayList<IntArray>()

        fun isUnique(now: IntArray): Boolean {

            val set = relation.map {
                it.filterIndexed { index, s -> now.contains(index) }.joinToString("")
            }.toSet()

            return set.size == rowsSize
        }

        fun makeCombi(k: Int, i: Int, now: IntArray) {

            if (now.size == k) {
                if (isUnique(now)) answerArr.add(now)
                return
            }
            if (i !in cols.indices) return
            
            // 정답배열에 있는 조합과 완전히 겹치는 조합이 아닌것들만 새로운 조합으로 만든다.
            if (answerArr.all { (it.toSet() - (now + cols[i]).toSet()).size >= 1 } ) makeCombi(k, i + 1, now + cols[i])
            makeCombi(k, i + 1, now)
        }

        for (k in 1..cols.size) {
            makeCombi(k, 0, intArrayOf())
        }

        return answerArr.size
    }
}