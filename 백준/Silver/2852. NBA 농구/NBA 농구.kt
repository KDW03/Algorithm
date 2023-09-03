fun main() {
    val n = readLine()!!.toInt()
    var team1Time = 0
    var team2Time = 0
    var lastTime = 0
    var lastScore = 0
    var team1Score = 0
    var team2Score = 0

    for (i in 0 until n) {
        val (team, time) = readLine()!!.split(" ")
        val (minute, second) = time.split(":").map { it.toInt() }
        val currentTime = minute * 60 + second

        if (team1Score > team2Score) {
            team1Time += currentTime - lastTime
        } else if (team2Score > team1Score) {
            team2Time += currentTime - lastTime
        }

        if (team == "1") {
            team1Score++
        } else {
            team2Score++
        }

        lastTime = currentTime
    }

    val remainingTime = 48 * 60 - lastTime
    if (team1Score > team2Score) {
        team1Time += remainingTime
    } else if (team2Score > team1Score) {
        team2Time += remainingTime
    }

    println("${String.format("%02d",team1Time / 60)}:${String.format("%02d", team1Time % 60)}")
    println("${String.format("%02d",team2Time / 60)}:${String.format("%02d", team2Time % 60)}")
}
