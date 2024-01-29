fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val countMap = hashMapOf<String, Int>()
    repeat(n) {
        val word = br.readLine()
        if (word.length >= m) {
            countMap[word] = countMap.getOrDefault(word, 0) + 1
        }
    }

    countMap.entries.sortedWith(compareByDescending<MutableMap.MutableEntry<String, Int>> { it.value }.thenByDescending { it.key.length }
        .thenBy { it.key })
        .forEach {
            bw.write("${it.key}\n")
        }
    bw.flush()
    bw.close()
}
