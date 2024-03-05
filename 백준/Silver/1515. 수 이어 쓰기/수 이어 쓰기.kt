fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    var num = 0
    var ptr = 0

    while (num++ < 30000) {
        val num2str = num.toString()
        for (element in num2str) {
            if (str[ptr] == element) ptr++
            if (ptr == str.length) {
                println(num)
                return
            }
        }
    }
}