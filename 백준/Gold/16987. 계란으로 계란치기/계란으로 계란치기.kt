data class Egg(
    var durability: Int, var weight: Int
)

var max = 0

fun main() {

    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val eggList = Array<Egg?>(n) { null }
    val broken = BooleanArray(n)
    for (i in 0 until n) {
        br.readLine().split(" ").let {
            eggList[i] = (Egg(it[0].toInt(), it[1].toInt()))
        }
    }

    for (i in 1 until n) {
        val copy = eggList.map { it?.copy() }.toTypedArray()
        dfs(0, i, n, copy, broken.copyOf())
    }

    println(max)

}

fun dfs(pick: Int, target: Int, lastIdx: Int, eggList: Array<Egg?>, broken: BooleanArray) {
    eggList[pick]!!.durability -= eggList[target]!!.weight
    eggList[target]!!.durability -= eggList[pick]!!.weight

    var flag = false
    if (eggList[pick]!!.durability <= 0) {
        broken[pick] = true
        flag = true
    }
    if (eggList[target]!!.durability <= 0) {
        broken[target] = true
        flag = true
    }
    if (flag){
        max = maxOf(max, broken.count { it })
    }
    if (pick == lastIdx - 1) return
    var next = -1
    for (i in pick + 1 until lastIdx) {
        if (!broken[i]) {
            next = i
            break
        }
    }

    if (next == -1) return

    for (i in 0 until lastIdx) {
        if (i == next) continue
        if (!broken[i]) {
            val copy = eggList.map { it?.copy() }.toTypedArray()
            dfs(next, i, lastIdx, copy, broken.copyOf())
        }
    }
}

