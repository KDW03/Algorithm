fun main() {
    val br = System.`in`.bufferedReader()
    val dest = br.readLine().toLong() * 2
    var now = 1L
    while (true) {
        val sum = now * (now + 1)
        if (sum >= dest) {
            if (sum == dest){
                println(now)
            }else {
                println(now - 1)
            }
            break
        }
        now++
    }
}