import kotlin.collections.ArrayList

const val MOD = 1000000007

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m, k) = br.readLine().split(" ").map { it.toInt() }
    val nums = ArrayList<Long>()
    repeat(n) {
        nums.add(br.readLine().toLong())
    }

    val sb = StringBuilder()
    val segment = SegmentTree(nums.toLongArray())
    repeat(k + m) {
        val (a, b, c) = br.readLine().split(" ").map { it.toInt() }
        // update
        if (a == 1) {
            segment.updateUtil(b, c)
        }
        // query
        if (a == 2) {
            sb.append(segment.queryUtil(b, c) % MOD).append("\n")
        }
    }
    print(sb.toString())
}

class SegmentTree(val nums: LongArray) {

    private val size = nums.size
    private val tree = LongArray(4 * size) { 1L }
    
    init {
        build(0, size - 1, 0)
    }

    private fun build(start: Int, end: Int, idx: Int) {
        if (start == end) {
            tree[idx] = nums[start]
        } else {
            val mid = (start + end) / 2
            build(start, mid, 2 * idx + 1)
            build(mid + 1, end, 2 * idx + 2)
            tree[idx] = (tree[2 * idx + 1] * tree[2 * idx + 2]) % MOD
        }
    }

    fun updateUtil(b: Int, c: Int) {
        update(0, size - 1, 0, b - 1, c.toLong())
    }


    private fun update(start: Int, end: Int, idx: Int, updateIdx: Int, updateValue: Long) {

        if (updateIdx < start || updateIdx > end) return
        if (start == end) {
            tree[idx] = updateValue
            nums[updateIdx] = updateValue
        } else {
            val mid = (start + end) / 2
            update(start, mid, idx * 2 + 1, updateIdx, updateValue)
            update(mid + 1, end, idx * 2 + 2, updateIdx, updateValue)
            tree[idx] = (tree[2 * idx + 1] * tree[2 * idx + 2]) % MOD
        }
    }

    fun queryUtil(b: Int, c: Int): Long {
        return query(0, size - 1, 0, b - 1, c - 1) % MOD
    }

    private fun query(start: Int, end: Int, idx: Int, qs: Int, qe: Int): Long {
        if (qs > end || qe < start) return 1
        if (qs <= start && qe >= end) return tree[idx]
        val mid = (start + end) / 2
        return (query(start, mid, 2 * idx + 1, qs, qe) * query(mid + 1, end, 2 * idx + 2, qs, qe)) % MOD
    }
}
