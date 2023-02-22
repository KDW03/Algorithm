fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val al: ArrayList<Int> = arrayListOf()
    for(i in 0 until n){
        al.add(br.readLine().toInt())
    }
    al.sortDescending()
    var count : Long = 0L
    for(i in al.indices){
        val tip = al[i] - i
        if (tip > 0)
            count += tip
    }
    println(count)
}