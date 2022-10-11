import java.util.Collections

fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val arr = ArrayList<Int>(n)
    repeat(n){ arr.add(br.readLine().toInt()) }
    Collections.sort(arr)
    for (i in arr)
        sb.append(i).append("\n")
    println(sb.toString())
}
