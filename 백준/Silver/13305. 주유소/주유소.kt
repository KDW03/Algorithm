fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val o = br.readLine().split(" ").map { it.toInt() }
    val p = br.readLine().split(" ").map { it.toInt() }
    
    var totalPrice = 0
    var nowP = p[0]
    var move = o[0]
    for (i in 1 until n - 1) {
        if (nowP > p[i]) {
            totalPrice += move * nowP
            nowP = p[i]
            move = 0
        }
        move += o[i]
    }
    println(totalPrice + (move * nowP))
}
