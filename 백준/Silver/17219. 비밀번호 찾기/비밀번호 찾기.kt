fun main() {
    val br = System.`in`.bufferedReader()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val hash: HashMap<String, String> = hashMapOf()

    repeat(n) {
        val (id, pw) = br.readLine().split(" ")
        hash[id] = pw
    }

    val sb = StringBuilder()
    repeat(m) {
        sb.append(hash[br.readLine()]).append("\n")
    }
    print(sb.toString())
}