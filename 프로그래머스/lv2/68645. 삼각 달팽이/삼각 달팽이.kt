class Solution {
    fun solution(n: Int): IntArray {

        val arr : ArrayList<IntArray> = arrayListOf()
        for(i in 1 .. n)
            arr.add(IntArray(i))
        var x = -1
        var y = 0
        var curNum = 1
        for(i in n downTo 0 step 3) {
            for(j in 0 until i) { arr[++x][y] = curNum++ }
            for(j in 0 until i - 1) { arr[x][++y] = curNum++ }
            for(j in 0 until i - 2) { arr[--x][--y] = curNum++ }
        }
        return arr.flatMap { it.toList() }.toIntArray()
    }
}
