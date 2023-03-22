var al = ArrayList<Long>()

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()-1
    for (i in 0..9) {
        dfs(i.toString(), i)
    }
    al.sort()
    if (n >= al.size) {
        println(-1)
    }else{
        println(al[n])
    }
}

fun dfs(now: String, last: Int) {
    al.add(now.toLong())
    for (i in last - 1 downTo 0) {
        dfs(now + i.toString(), i)
    }
}