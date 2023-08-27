fun main() {
    val br = System.`in`.bufferedReader()
    val k = br.readLine().toInt()
    val sb = StringBuilder()
    var arr = br.readLine().split(" ").reversed()
    while (arr.isNotEmpty()){
        sb.append(arr.filterIndexed { i, v -> i % 2 == 0 }.joinToString(" ") { it.reversed() }).append("\n")
        arr = arr.filterIndexed { i , v -> i % 2 == 1 }
    }
    print(sb.toString().reversed().trim())
}