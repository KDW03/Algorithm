import kotlin.math.*
import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val nums : ArrayList<Int> = ArrayList()
    repeat (n) {
        nums.add(br.readLine().toInt())
    }
    val segmentTree = SegmentTree(nums.toIntArray())
    sb.append(segmentTree.getMaxArea(0, n - 1)).append("\n")
    print(sb.toString())
}

class SegmentTree(private val heights: IntArray) {

    private val size = heights.size
    private val tree: IntArray = IntArray(4 * size)

    init {
        build(0, 0, size - 1)
    }

    private fun build(node: Int, start: Int, end: Int) {
        if (start == end) {
            tree[node] = start
        } else {
            val mid = (start + end) / 2
            build(node * 2 + 1, start, mid)
            build(node * 2 + 2, mid + 1, end)
            tree[node] =
                if (heights[tree[node * 2 + 1]] < heights[tree[node * 2 + 2]])
                    tree[node * 2 + 1]
                else
                    tree[node * 2 + 2]
        }
    }

    private fun query(node: Int, start: Int, end: Int, left: Int, right: Int): Int {
        if (right < start || end < left) return -1
        if (left <= start && end <= right) return tree[node]

        val mid = (start + end) / 2
        val m1 = query(node * 2 + 1, start, mid, left, right)
        val m2 = query(node * 2 + 2, mid + 1, end, left, right)

        if (m1 == -1) return m2
        if (m2 == -1) return m1
        return if (heights[m1] < heights[m2]) m1 else m2
    }

    fun getMaxArea(left: Int, right: Int): Long {
        val mIndex = query(0, 0, size - 1, left, right)
        var area : Long = (right - left + 1).toLong() * heights[mIndex]

        if (left < mIndex) { // 왼쪽 구간에 대한 최대 넓이
            area = max(area, getMaxArea(left, mIndex - 1))
        }

        if (mIndex < right) { // 오른쪽 구간에 대한 최대 넓이
            area = max(area, getMaxArea(mIndex + 1, right))
        }

        return area
    }
}