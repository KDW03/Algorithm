fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val arr = ArrayList<Pair<String,Int>>()

    repeat(n) {
        val (name,value) = br.readLine().split(" ")
        arr.add(Pair(name,value.toInt()))
    }
    val sb = StringBuilder()
    var preFind = -1
    var preFindIndex = 0
    repeat(m) {
        val findValue = br.readLine().toInt()
        var s = 0
        var e = n - 1

        if (preFind != -1) {
            if (preFind > findValue) {
                e = preFindIndex
            }else {
                s = preFindIndex
            }
        }

        while (s <= e) {
            val mid = (s + e) / 2
            val value = arr[mid].second
            if (findValue > value) {
                s = mid + 1
            }else {
                e = mid - 1
            }
        }

        preFind = findValue
        preFindIndex = s

        val answer = arr[s]
        sb.append(answer.first).append("\n")
    }

    print(sb.toString())
}