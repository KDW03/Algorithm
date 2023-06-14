fun main() {
    val br = System.`in`.bufferedReader()
    // 총 도시 수
    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val parentArr = IntArray(n + 1) { it }

    repeat(n) {
        // 1인 인덱스만 남겨서
        br.readLine().split(" ").mapIndexed { index, s ->
            if (s == "1") index else -1
        }.filter { it != -1 }.forEach { idx ->
            union(parentArr, idx + 1, it + 1)
        }

    }

    val plan = br.readLine().split(" ").map { it.toInt() }
    plan.forEach {
        if (!isSame(parentArr,plan[0],it)) {
            println("NO")
            return
        }
    }
    println("YES")
}


// 부모를 재귀적으로 탐색해서 찾아가는 것
fun findParent(parentArr: IntArray, x: Int): Int {
    if (parentArr[x] == x) return x
    parentArr[x] = findParent(parentArr, parentArr[x])
    return parentArr[x]
}


fun union(parentArr: IntArray, a: Int, b: Int) {
    // a 와 b 의 부모를 찾는다
    val pa = findParent(parentArr, a)
    val pb = findParent(parentArr, b)

    // 부모가 더 작은 쪽으로 동일하게 갱신 해줌
    if (pa > pb) {
        parentArr[pa] = pb
    } else {
        parentArr[pb] = pa
    }
}


fun isSame(parentArr: IntArray, a: Int, b: Int): Boolean = findParent(parentArr, a) == findParent(parentArr, b)

