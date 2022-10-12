fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val ownCard  = br.readLine().split(' ').map { it.toInt() }
    val m = br.readLine().toInt()
    val findCard = br.readLine().split(' ').map { it.toInt() }
    val sb = StringBuilder()
    val hashMap = HashMap<Int,Int>()


    for (i in ownCard)
        hashMap[i] = hashMap.getOrDefault(i,0)+1
    
    for (i in findCard)
        sb.append(hashMap.getOrDefault(i,0)).append(" ")
    

    println(sb.toString())
}
