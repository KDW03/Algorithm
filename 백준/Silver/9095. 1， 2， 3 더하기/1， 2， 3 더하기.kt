fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt() //테스트케이스 개수
    val sb = StringBuilder()
    repeat(t){
        val n = br.readLine().toInt()
        val dp = IntArray(12)
        dp[1] = 1;dp[2] = 2;dp[3] = 4
        if (n <= 3){
            sb.append(dp[n]).append("\n")
        }else{
            for (i in 4 .. n){
                dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
            }
            sb.append(dp[n]).append("\n")
        }
    }
    println(sb.toString())
}