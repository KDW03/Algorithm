import kotlin.math.abs

var min = Int.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    combination(arr, (0 until n).toList(), n / 2)
    println(min)
}

fun combination(arr: Array<IntArray>, list: List<Int>, k: Int, i: Int = 0, new: MutableSet<Int> = mutableSetOf()) {
    if (new.size == k) {
        val aTeam = list - new
        val bTeam = new.toList()
        var sumA = 0
        var sumB = 0
        for (first in 0 until aTeam.size - 1) {
            for (two in first + 1 until aTeam.size) {
                val fi = aTeam[first]
                val si = aTeam[two]
                sumA += arr[fi][si] + arr[si][fi]
            }
        }

        for (first in 0 until new.size - 1) {
            for (two in first + 1 until new.size) {
                val fi = bTeam[first]
                val si = bTeam[two]
                sumB += arr[fi][si] + arr[si][fi]
            }
        }

        min = minOf(min, abs(sumA - sumB))
        return
    }

    if (i == list.size) return

    combination(arr, list, k, i + 1, new.apply { add(list[i]) })
    new.apply { remove(list[i]) }
    combination(arr, list, k, i + 1, new)
}
