val hashSet = HashSet<Int>()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val arr = Array(n) { 0 }
    repeat(n) {
        arr[it] = br.readLine().toInt()
    }
    find(arr, n, k)
    println(hashSet.size)
}

fun <T> find(
    arr: Array<T>,
    n: Int,
    k: Int,
    visited: BooleanArray = BooleanArray(n),
    curArray: Array<T> = arr.sliceArray(0 until k),
    curSelect: Int = 0,
) {
    if (k == curSelect) {
        hashSet.add(curArray.joinToString("").toInt())
        return
    }
    for (i in arr.indices) {
        if (!visited[i]) {
            visited[i] = true
            curArray[curSelect] = arr[i]
            find(arr, n, k, visited, curArray, curSelect + 1)
            visited[i] = false
        }
    }
}

