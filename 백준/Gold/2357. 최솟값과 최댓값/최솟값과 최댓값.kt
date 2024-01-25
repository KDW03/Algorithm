fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val nums = IntArray(n) { br.readLine().toInt() }
    val segmentTree = SegmentTree(nums)
    segmentTree.buildTree(0, nums.size - 1, 1)

    val sb = StringBuilder()
    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val result = segmentTree.query(a - 1, b - 1)
        sb.append("${result.second} ${result.first}").append("\n")
    }
    print(sb.toString())
}

class SegmentTree(private val arr: IntArray) {
    private val n: Int = arr.size
    private val tree = Array(4 * n) { Pair(Int.MIN_VALUE, Int.MAX_VALUE) }

    fun buildTree(start: Int, end: Int, node: Int) {
        if (start == end) {
            tree[node] = Pair(arr[start], arr[start])
            return
        }
        val mid = (start + end) / 2
        buildTree(start, mid, node * 2)
        buildTree(mid + 1, end, node * 2 + 1)
        tree[node] = Pair(
            maxOf(tree[node * 2].first, tree[node * 2 + 1].first),
            minOf(tree[node * 2].second, tree[node * 2 + 1].second)
        )
    }

    fun query(left: Int, right: Int, start: Int = 0, end: Int = n - 1, node: Int = 1): Pair<Int, Int> {
        if (right < start || left > end) return Pair(Int.MIN_VALUE, Int.MAX_VALUE)
        if (left <= start && right >= end) return tree[node]
        val mid = (start + end) / 2
        val a = query(left, right, start, mid, node * 2)
        val b = query(left, right, mid + 1, end, node * 2 + 1)
        return Pair(maxOf(a.first, b.first), minOf(a.second, b.second))
    }
}