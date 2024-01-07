fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var count = 0
    var powerOfFive = 5
    
    while (n / powerOfFive > 0) {
        count += n / powerOfFive
        powerOfFive *= 5
    }

    println(count)
}