fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(' ').map { it.toInt() }
    val first = Array(n){""}
    val two = Array(m){""}
    var sum = 0
    repeat(first.size){
        first[it] = br.readLine()
    }
    repeat(two.size){
        two[it] = br.readLine()
    }
    for (i in  0 until n)
        sum += two.count { it == first[i] }
   print(sum)
}


