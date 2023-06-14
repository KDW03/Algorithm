
fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val parentArr = IntArray(n + 1) { it }
    val sb = StringBuilder()
    repeat(m) {
        val (c, a, b) = br.readLine().split(" ").map { it.toInt() }
        if (c == 1) {
            sb.append(if (isSame(parentArr, a, b)) "YES" else "NO").append("\n")
        } else {
            union(parentArr, a, b)
        }
    }
    print(sb.toString())
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

