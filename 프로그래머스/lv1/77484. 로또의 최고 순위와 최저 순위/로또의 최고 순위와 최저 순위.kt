class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {

        val minHit = lottos.count { num ->
            win_nums.contains(num)
        }

        val maxHit = minHit + lottos.count { num ->
            num == 0
        }

        return intArrayOf(maxHit, minHit).map { hit ->
            7 - hit
        }.map { rank ->
            if (rank >= 6) 6 else rank
        }.toIntArray()

    }
}