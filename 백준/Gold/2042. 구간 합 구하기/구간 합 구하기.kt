fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val arr = LongArray(n) { br.readLine().toLong() }
    val segmentTree = SegmentTree(arr)
    val sb = StringBuilder()

    repeat(m + k) {
        val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
        if (a == 1L) {
            segmentTree.update(b.toInt() - 1, c)
        } else {
            sb.append(segmentTree.sum(b.toInt() - 1, c.toInt() - 1)).append("\n")
        }
    }
    println(sb.toString())
}

class SegmentTree(private val arr: LongArray) {
    private val tree: LongArray
    private val n: Int = arr.size

    init {
        var size = 1
        while (size < n) size *= 2
        tree = LongArray(size * 2)
        build(0, n - 1, 1)
    }

    private fun build(start: Int, end: Int, node: Int) {
        if (start == end) {
            tree[node] = arr[start]
        } else {
            val mid = (start + end) / 2
            build(start, mid, 2 * node)
            build(mid + 1, end, 2 * node + 1)
            tree[node] = tree[2 * node] + tree[2 * node + 1]
        }
    }

    fun update(idx: Int, value: Long, start: Int = 0, end: Int = n - 1, node: Int = 1) {
        if (idx < start || idx > end) return
        if (start == end) {
            tree[node] = value
        } else {
            val mid = (start + end) / 2
            update(idx, value, start, mid, 2 * node)
            update(idx, value, mid + 1, end, 2 * node + 1)
            tree[node] = tree[2 * node] + tree[2 * node + 1]
        }
    }

    fun sum(left: Int, right: Int, start: Int = 0, end: Int = n - 1, node: Int = 1): Long {
        if (left > end || right < start) return 0
        if (left <= start && end <= right) return tree[node]
        val mid = (start + end) / 2
        return sum(left, right, start, mid, 2 * node) + sum(left, right, mid + 1, end, 2 * node + 1)
    }
}
