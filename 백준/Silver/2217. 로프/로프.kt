fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = IntArray(n)
    for(i in 0 until n){
        arr[i] = br.readLine().toInt()
    }
    var max = 0
    for((i,value) in arr.sorted().withIndex()){
        val tmp = value * (n-i)
        if(tmp > max){
            max = tmp
        }
    }
    println(max)
}