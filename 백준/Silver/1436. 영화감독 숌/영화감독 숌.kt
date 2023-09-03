fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var count = 1
    var now = 666

    while (count != n){
        now++
        if (now.toString().contains("666")){
            count++
        }
    }
    println(now)
}
