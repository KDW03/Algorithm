data class Space(var durability: Int, var isHave: Boolean = false) {

    fun canAddRobot(): Boolean = !isHave && durability >= 1

    fun addRobot() {
        isHave = true
        durability--
    }

}


data class RoBot(var nowLocation: Int = 0) {
    fun moveNext(twoN: Int) {
        if (nowLocation + 1 == twoN) {
            nowLocation = 0
        } else {
            nowLocation++
        }
    }
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val spaceList = br.readLine().split(" ").map { Space(it.toInt()) }.toMutableList()
    val robotList: MutableList<RoBot> = mutableListOf()
    var answer = 1

    while (true) {
        moveBelt(spaceList, robotList)
        moveRobot(spaceList, robotList)
        if (spaceList[0].canAddRobot()) {
            robotList.add(RoBot())
            spaceList[0].addRobot()
        }
        if (spaceList.count { it.durability == 0 } >= k) break
        answer++
    }

    println(answer)
}


fun moveBelt(spaceList: MutableList<Space>, robotList: MutableList<RoBot>) {
    // belt이동
    spaceList.add(0, spaceList.removeLast())
    val twoN = spaceList.size
    robotList.forEach {
        it.moveNext(twoN)
    }

    val downIdx = twoN / 2 - 1
    if (robotList.remove(RoBot(downIdx))) spaceList[downIdx].isHave = false
}

fun moveRobot(spaceList: MutableList<Space>, robotList: MutableList<RoBot>) {

    val twoN = spaceList.size
    val downIdx = twoN / 2 - 1

    robotList.forEach {
        val now = it.nowLocation
        val next = if (now + 1 in spaceList.indices) now + 1 else 0
        if (spaceList[next].canAddRobot()) {
            spaceList[now].isHave = false
            spaceList[next].addRobot()
            it.nowLocation = next
        }
    }

    if (robotList.remove(RoBot(downIdx))) spaceList[downIdx].isHave = false
}
