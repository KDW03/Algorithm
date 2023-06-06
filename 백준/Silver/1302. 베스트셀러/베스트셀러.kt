fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val hashMap = HashMap<String, Int>()

    repeat(n) {
        val title = br.readLine()
        if (hashMap[title] == null) hashMap[title] = 0
        hashMap[title] = hashMap[title]!!.plus(1)
    }

    hashMap.toList().sortedBy {
        it.first
    }.maxByOrNull {
        it.second
    }.let {
        println(it?.first)
    }

}
