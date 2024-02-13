import kotlin.math.*

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    while (true) {
        val nums = br.readLine().split(" ").map { it.toInt() }
        val n = nums.first()
        if (n == 0) break
        val segmentTree = SegmentTree(nums.drop(1).toIntArray())
        sb.append(segmentTree.getMaxArea(0, n - 1)).append("\n")
    }
    print(sb.toString())
}

class SegmentTree(private val heights: IntArray) {

    private val size = heights.size
    private val tree: IntArray = IntArray(4 * size)

    init {
        build(0, 0, size - 1)
    }

    private fun build(node: Int, start: Int, end: Int) {
        // 리프노드에는 인덱스를 저장
        if (start == end) {
            tree[node] = start
        } else {
            val mid = (start + end) / 2
            build(node * 2 + 1, start, mid)
            build(node * 2 + 2, mid + 1, end)
            // 부모 노드에는 두 자식 중 높이가 낮은 막대의 인덱스를 저장
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
        // 더 낮은 높이를 가진 막대의 인덱스 반환
    }

    fun getMaxArea(left: Int, right: Int): Long {
        val mIndex = query(0, 0, size - 1, left, right)
        // mIndex를 최소 높이로 포함하는 최대 직사각형 사이즈
        var area : Long = (right - left + 1).toLong() * heights[mIndex]
        // mIndex를 제외한 부분에 대해서도 반복

        // mIndex 왼쪽에 남은 구간이 있다면
        if (left < mIndex) { // 왼쪽 구간에 대한 최대 넓이
            area = max(area, getMaxArea(left, mIndex - 1))
        }

        // mIndex 오른쪽에 남은 구간이 있다면
        if (mIndex < right) { // 오른쪽 구간에 대한 최대 넓이
            area = max(area, getMaxArea(mIndex + 1, right))
        }

        return area
    }
}