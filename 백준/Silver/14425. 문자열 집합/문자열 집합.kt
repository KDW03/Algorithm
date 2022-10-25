fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    val map = HashMap<String,Int>()
    for (i in 0 until n){
        val temp = br.readLine().toString()
        map[temp] = 1
    }
    var sum = 0
    for (i in 0 until m){
        val temp = br.readLine()
        if (map[temp] != null) sum ++
    }
   print(sum)
}