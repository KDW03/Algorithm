fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t) {
        val hashMap = HashMap<String, Int>()
        val n = br.readLine().toInt()
        repeat(n) {
            val type = br.readLine().split(" ")[1]
            hashMap[type] = (hashMap[type] ?: 1) + 1
        }
        sb.append(hashMap.values.fold(1){acc, i ->  acc * i } - 1).append("\n")
    }
    println(sb.toString())
}