fun main() {
    val br = System.`in`.bufferedReader()
    val arr = IntArray('z' - 'a' + 1)

    br.readLine().forEach {
        arr[it - 'a']++
    }

    println(arr.joinToString(" "))
}