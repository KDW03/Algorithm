data class Work(
    val time: Int,
    val pay: Int
)

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n+1)
    val workArray = Array<Work?>(n) { null }

    repeat(n) { day ->
        br.readLine().split(" ").map { it.toInt() }.let {
            val time = it[0]
            val pay = it[1]
            if (day + time <= n) workArray[day] = Work(time, pay)
        }
    }

    for (i in n-1 downTo 0){
        val nowWork = workArray[i]
        if (nowWork != null){
            dp[i] = maxOf(dp[i+1],dp[i + nowWork.time] + nowWork.pay)
        }else{
            dp[i] = dp[i+1]
        }
    }

    print(dp.maxOrNull())
}