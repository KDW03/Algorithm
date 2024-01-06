fun main() {
    val br = System.`in`.bufferedReader()
    val gr = br.readLine().groupingBy { it.uppercase() }.eachCount()
    val max = gr.values.max()
    val ans = gr.filter { it.value == max }.keys.joinToString("")

    println(
        if (ans.length == 1) {
            ans
        } else {
            '?'
        }
    )

}
