fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    val set = hashSetOf<String>()
    // s부터 시작해서 e까지 부분
    for (s in str.indices) {
        set.add(str[s].toString())
        for (e in s + 1 until str.length) {
            set.add(str.substring(s..e))
        }
    }
    println(set.size)
}