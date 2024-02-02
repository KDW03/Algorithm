fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)
    val prime = BooleanArray(n + 1) { true }
    prime[0] = false
    prime[1] = false
    val primes = ArrayList<Int>()

    for(i in 2 until prime.size) {
        if(prime[i]) {
            primes.add(i)
            for(x in 2 * i until prime.size step i) {
                prime[x] = false
            }
        }        
    }
    
    val filterList = primes.filter { it <= n }.sorted().toTypedArray()
    for(i in 1 until filterList.size) filterList[i] += filterList[i-1]
    var count = 0
    var start = 0
    var end = 0
    while(start in filterList.indices && end in filterList.indices) {
        var sum = filterList[end]
        if(start - 1 >= 0) sum -= filterList[start - 1]
        if(sum > n) {
            start++
        }else {
            if(sum == n) count++  
            end++
        } 
    }
    println(count)
}