fun main() {
    val br = System.`in`.bufferedReader()
    var polrio = br.readLine()
    polrio = polrio.replace("XXXX","AAAA")
    polrio = polrio.replace("XX","BB")
    if(polrio.contains("X")){
        print(-1)
    }else{
        print(polrio)
    }
}