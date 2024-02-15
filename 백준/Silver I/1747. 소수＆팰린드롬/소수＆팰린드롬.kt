fun main() {
    val size = 1003001
    val prime = BooleanArray(size + 1) { true }
    prime[0] = false
    prime[1] = false
    for (i in 2 until prime.size) {
        if (prime[i]) {
            for (x in i * 2 until prime.size step i) {
                prime[x] = false
            }
        }
    }

    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    // n보다 크거나 같은
    for (i in n until prime.size) {
        if (prime[i] && i.toString() == i.toString().reversed()) {
            println(i)
            break
        }
    }
}