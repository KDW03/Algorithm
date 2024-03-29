fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val hashMap = HashMap<String, String>()
    val sb = StringBuilder()
    repeat(n) {
        val tmp = br.readLine().split(" ")
        hashMap[tmp[0]] = tmp[1]
    }
    

    hashMap.filter {
        it.value == "enter"
    }.map {
        it.key
    }.sortedDescending().forEach {
        sb.append(it).append("\n")
    }

    print(sb.toString())
}
