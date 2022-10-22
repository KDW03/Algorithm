fun main() {
    val br = System.`in`.bufferedReader()
    val wordTable = arrayOf("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    val arr = Array<ArrayList<String>>('z'.code + 1) { ArrayList() }
    for (word in wordTable)
        arr[word.first().code].add(word.substring(1))
    val temp = br.readLine()
    var result = 0
    var idx = 0
    outer@while (idx < temp.length){
        for (str in arr[temp[idx].code]){
            //arraylist탐색하면서
            val length = str.length
            if (temp.length > idx+length && str == temp.substring(idx+1,idx+1+length)){
                //그 크기만큼 잘랐을때 뒷 부분이 현재 거낸 크로티아랑 같다면
                result ++ // 단어 개수 증가
                idx += (length+1) // idx 넘어가고
                continue@outer
            }
        }
        result ++
        idx ++
    }
    println(result)
}
