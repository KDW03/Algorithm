fun main() {
    val br = System.`in`.bufferedReader()
    var (n, k) = br.readLine().split(' ').map { it.toInt() }
    val arr = IntArray(n)
    for (i in 0 until n){
        arr[i] = br.readLine().toInt()
    }
    arr.reverse()
    var result = 0
    for (i in arr){
        if (k == 0) break
        if (i > k) continue
        result += k / i //개수
        k %= i
    }
    println(result)
}



