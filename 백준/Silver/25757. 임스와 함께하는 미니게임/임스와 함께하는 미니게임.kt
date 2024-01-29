fun main() {
    val br = System.`in`.bufferedReader()
    val (n, type) = br.readLine().split(" ")
    val set: MutableSet<String> = mutableSetOf()

    repeat(n.toInt()) {
        set.add(br.readLine())
    }

    val r = when (type) {
        "Y" -> {
            1
        }
        "F" -> {
            2
        }
        else -> {
            3
        }
    }

    println(set.size / r)
}