import java.util.*
import kotlin.collections.ArrayList

const val MOD = 1000000007

fun main() {
    val br = System.`in`.bufferedReader()

    // m 변경 일어난 횟수
    // k 구간의 곱을 구하는 횟수
    // n 개의 수
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
            sb.append(segment.queryUtil(b, c)).append("\n")
        }
    }
    print(sb.toString())
}

class SegmentTree(val nums: LongArray) {
    val size = nums.size
    val tree = LongArray(4 * size) { 1L }

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


    // b번째를 c로 바꾸기
    fun updateUtil(b: Int, c: Int) {
        update(0, size - 1, 0, b - 1, c)
    }


    private fun update(start: Int, end: Int, idx: Int, updateIdx: Int, updateValue: Int) {

        // 범위에서 아예 벗어난다면
        if (updateIdx < start || updateIdx > end) return
        // updateIdx까지 왔다면
        if (start == end) {
            tree[idx] = updateValue.toLong()
            nums[updateIdx] = updateValue.toLong()
        } else {
            val mid = (start + end) / 2
            update(start, mid, idx * 2 + 1, updateIdx, updateValue)
            update(mid + 1, end, idx * 2 + 2, updateIdx, updateValue)
            tree[idx] = (tree[2 * idx + 1] * tree[2 * idx + 2]) % MOD
        }
    }

    // b에서 c까지 구간 곱
    fun queryUtil(b: Int, c: Int): Long {
        return query(0, size - 1, 0, b - 1, c - 1) % MOD
    }

    private fun query(start: Int, end: Int, idx: Int, qs: Int, qe: Int): Long {
        // 범위에 벗어나면 1 리턴
        if (qs > end || qe < start) return 1
        // 범위에 포함되면 tree[idx]리턴
        // 쿼리하는 부분이 더 커야함 start보다 qs가 작거나 같고 , end보다 qe가 크거나 같고
        if (qs <= start && qe >= end) return tree[idx]
        val mid = (start + end) / 2
        // 자식 노드로 범위 분산시키면서 탐색
        return (query(start, mid, 2 * idx + 1, qs, qe) * query(mid + 1, end, 2 * idx + 2, qs, qe)) % MOD
    }
}

// 3  5
// 2 4
