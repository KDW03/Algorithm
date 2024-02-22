data class Position(var x: Int, var y: Int) {

    fun move(park: List<CharArray>, dir: Direction, weight: Int) {
        var flag = true
        var nowX = x
        var nowY = y
        for (i in 0 until weight) {
            val nx = nowX + dir.x
            val ny = nowY + dir.y
            
            if (nx in park.indices && ny in park[0].indices && park[nx][ny] == 'O') {
                nowX = nx
                nowY = ny
            }else{
                flag = false
                break
            }
        }
        if (flag) {
            park[x][y] = 'O'
            this.x = nowX
            this.y = nowY
            park[x][y] = 'S'
        }
    }

    fun positionToIntArray(): IntArray = intArrayOf(x,y)
}

enum class Direction(val x: Int, val y: Int) {
    N(-1, 0),
    S(1, 0),
    W(0, -1),
    E(0, 1),
}

class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var now = Position(0, 0)
        val parks = park.map { it.toCharArray() }
        
        parks.forEachIndexed { x, v ->
            v.forEachIndexed { y, c ->
                if (c == 'S') now = Position(x, y)
            }
        }

        routes.forEach {
            val tmp = it.split(" ")
            val dir = Direction.valueOf(tmp[0])
            val weight = tmp[1].toInt()

            now.move(parks, dir, weight)
        }

        return now.positionToIntArray()
    }
}