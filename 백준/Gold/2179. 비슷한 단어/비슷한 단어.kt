fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val map = LinkedHashMap<String, Int>()
    val arr = Array(n) { br.readLine() }

    for (str in arr) {
        var pre = ""
        for (c in str) {
            pre += c
            map[pre] = map.getOrDefault(pre, 0) + 1
        }
    }

    val consStr = map.toList().filter { it.second >= 2 }.maxByOrNull { it.first.length }!!.first
    val answer = ArrayList<String>()

    for (str in arr) {
        if (str.startsWith(consStr)) {
            if (answer.isEmpty()) {
                answer.add(str)
            } else {
                if (answer.first() != str) {
                    answer.add(str)
                    break
                }
            }
        }
    }

    answer.forEach {
        println(it)
    }
}