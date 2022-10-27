fun main() {
    val br = System.`in`.bufferedReader()
    val sb = StringBuilder()
    val n = br.readLine().toInt()
    val arr = ArrayList<Pair<Int,Int>>()
    for (i in 0 until n){
        br.readLine().split(' ').map { it.toInt() }.let {
            arr.add(Pair(it[0],it[1]))
        }
    }
    for (i in arr){
        var count = 1
        for (j in arr){
            if (j.first > i.first && j.second > i.second){
                count++
            }
        }
        sb.append(count).append(" ")
    }
    print(sb.toString())
}


