data class Duct(val weight: Int, val value: Int)

fun main() {
    val br = System.`in`.bufferedReader()
    // n 물품의 수 , k 버틸수 있는 무게 최대한 많은 v
    val (N, K) = br.readLine().split(" ").map { it.toInt() }
    val set: MutableList<Duct> = mutableListOf()
    val dpTable = Array<ArrayList<Duct>>(K + 1) { arrayListOf() }

    repeat(N) {
        val (W, V) = br.readLine().split(" ").map { it.toInt() }
        set.add(Duct(W, V))
    }

    for (currentWeight in dpTable.indices) {
        for (duct in set) {
            val preIndex = currentWeight - duct.weight
            if (preIndex >= 0) {
                // 이전 꺼
                if (dpTable[preIndex].sumOf { it.value } + duct.value > dpTable[currentWeight].sumOf { it.value } && !dpTable[preIndex].contains(duct) ) {
                    dpTable[currentWeight] = dpTable[preIndex].toTypedArray().copyOf().toMutableList().apply { add(duct) } as ArrayList<Duct>
                }
            }

        }

    }

    println(dpTable.maxOf { it.sumOf { it.value } })
}