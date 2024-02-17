class Solution {
    fun solution(n: Int): IntArray {
        // n x n
        val answer = Array(n) { IntArray(n) }
        var dir = 0
        var x = -1
        var y = 0
        var num = 1
        // n번 n-1번 ... 1번
        for (i in n downTo 1) {
            // n번 n-1번 ... 1번
            for (j in 0 until i) {
                when (dir) {
                    0 -> {
                        x++
                    }
                    1 -> {
                        y++
                    }
                    2 -> {
                        x--
                        y--
                    }
                }
                answer[x][y] = num++
            }
            dir++
            dir %= 3
        }

        val ans = ArrayList<Int>()
        for (x in 0 until n) {
            for (y in 0..x) ans.add(answer[x][y])
        }

        return ans.toIntArray()
    }
}