var zeroCount = 0
var oneCount = 0

class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        val initWindowsSize = arr.size
        dfs(initWindowsSize, arr.toList().map { it.toList() })
        return intArrayOf(zeroCount, oneCount)
    }
}


fun dfs(initWindowsSize: Int, arr: List<List<Int>>) {

    if (initWindowsSize == 1) {
        if (arr[0][0] == 0) zeroCount++
        else oneCount++
        return
    }

    // 현재 arr안의 전체 더하기
    val sum = arr.sumOf {
        it.sumOf {
            it
        }
    }

    // arr 전체 요소 개수
    val elementSize = initWindowsSize * initWindowsSize

    // arr 1로 이루어졌는지 arr 0으로 이루어졌는지 검사
    if (elementSize == sum) oneCount++
    else if (0 == sum) zeroCount++
    else {
        val topOrLeftRange = 0 until initWindowsSize / 2
        val bottomOrRightRange = initWindowsSize / 2 until initWindowsSize

        val topArr = arr.slice(topOrLeftRange)
        val bottomArr = arr.slice(bottomOrRightRange)

        val topLeftArr = topArr.map { it.slice(topOrLeftRange) }
        val topRightArr = topArr.map { it.slice(bottomOrRightRange) }
        val bottomLeftArr = bottomArr.map { it.slice(topOrLeftRange) }
        val bottomRightArr = bottomArr.map { it.slice(bottomOrRightRange) }

        listOf(topLeftArr, topRightArr, bottomLeftArr, bottomRightArr).forEach {
            dfs(initWindowsSize / 2, it)
        }
    }
}