import java.util.*

class Solution {
    fun solution(relation: Array<Array<String>>): Int {
        //1 모든 키 조합을 구하자 현재 자기 자신 포함
        val keys: MutableList<Set<Int>> = mutableListOf()
        val size = relation[0].size
        val rowSize = relation.size
        keys.addAll(combinationKey(size))

        val answer: MutableList<Set<Int>> = mutableListOf()

        for (key in keys) {
            if (isUnique(relation, key, rowSize) && isMinimum(answer, key)) {
                answer.add(key)
            }
        }

        return answer.size
    }
}

// 키 조합이 최소성을 만족하는지
// 이전 정답 리스트에 이걸 포함하는게 있는지
fun isMinimum(answer: List<Set<Int>>, key: Set<Int>): Boolean {
    for (ans in answer) {
        if (key.containsAll(ans)) {
            return false
        }
    }
    return true
}

// 해당 키 조합이 유일한지
fun isUnique(relation: Array<Array<String>>, key: Set<Int>, rowSize: Int): Boolean {
    val set = mutableSetOf<String>()
    for (row in 0 until rowSize) set.add(key.joinToString { relation[row][it] })
    return rowSize == set.size
}


fun combinationKey(size: Int): List<Set<Int>> {
    //
    val result: MutableList<Set<Int>> = mutableListOf()
    val list = (0 until size).toList()
    fun combination(k: Int, idx: Int = 0, set: Set<Int> = setOf()) {
        if (k == set.size) {
            result.add(set)
            return
        }
        // 만약 현재 뽑을 인덱스가 전체 리스트 보다 크다면
        if (idx == size) return

        combination(k, idx + 1, set + list[idx])
        combination(k, idx + 1, set)
    }
    // 2개 부터
    for (i in 1..size) combination(i)
    return result
}