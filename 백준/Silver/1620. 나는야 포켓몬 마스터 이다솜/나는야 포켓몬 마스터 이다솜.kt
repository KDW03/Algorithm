fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val hashMap = LinkedHashMap<String, Int>(n)
    val arr = Array(n + 1) { "" }
    repeat(n) {
        val name = br.readLine()
        hashMap[name] = it + 1
        arr[it + 1] = name
    }
    val sb = StringBuilder()
    repeat(m) {
        val q = br.readLine()
        try {
            val i = q.toInt()
            sb.append(arr[i])
        } catch (e: Exception) {
            sb.append(hashMap[q])
        } finally {
            sb.append("\n")
        }
    }
    print(sb.toString())
}
