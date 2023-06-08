fun main(){
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(n){
        val input = br.readLine()
        val t = if (checkVPS(input)) "YES" else "NO"
        sb.append(t).append("\n")
    }
    print(sb.toString())
}

fun checkVPS(input : String) : Boolean{
    if (input.length % 2 != 0) return false
    var count = 0
    for (char in input){
        if (char == ')'){
            if (count <= 0) return false
            count--
        }else{
            count++
        }
    }
    return count == 0
}