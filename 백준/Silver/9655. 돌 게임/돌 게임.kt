fun main() {

    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()

    val dp = BooleanArray(1001) { true }
    dp[2] = false
    for (i in 4..1000)
        dp[i] = !(dp[i - 1] && dp[i - 3])
    //상대방에게 줄수 있는 패가 다 승리하는 경우 밖에 없으면 해당은 상근이 패배
    // 하나라도 패배할 수 있는 패가 있으면 그걸 준다 상근 승리
    if (dp[n])
        print("SK")
    else
        print("CY")

}