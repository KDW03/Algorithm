data class Position(val x: Int, val y: Int)

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {

        val moveX = arrayOf(0, 0, -1, 1)
        val moveY = arrayOf(1, -1, 0, 0)

        fun dfs(
            start: Position,
            place: Array<String>,
            cost: Int = 0,
            visited: Array<BooleanArray> = Array(5) { BooleanArray(5) }
        ): Boolean {
            // 비용이 2이상이면 더이상 할필요없다
            if (cost >= 2) return true
            
            var flag = true
            // 방문 처리
            visited[start.x][start.y] = true

            for (i in 0 until 4) {
                val nx = start.x + moveX[i]
                val ny = start.y + moveY[i]

                if (nx in 0 until 5 && ny in 0 until 5 && !visited[nx][ny]) {
                    // 사람이라면 false
                    if (place[nx][ny] == 'P') return false
                    // 파티션 있다면 더 이상 볼 필요 x
                    if (place[nx][ny] == 'X') continue
                    
                    // 빈 테이블이라면 더 탐색
                    flag = flag && dfs(Position(nx, ny), place, cost + 1, visited)
                }
            }

            return flag
        }

        fun check(place: Array<String>): Boolean {

            // 사람 포지션
            val pPositions = ArrayList<Position>()

            place.forEachIndexed { x, v ->
                v.forEachIndexed { y, c ->
                    if (c == 'P') pPositions.add(Position(x, y))
                }
            }

            // 모든 사람이 거리지키기 하고 있다면 true 한명이라도 아니라면 false
            return pPositions.all { start ->
                dfs(start, place)
            }
        }


        return places.map { place -> 
            // 각 place마다 체크
            // 지키고있으면 1
            if (check(place)) 1 else 0
        }.toIntArray()
    }
}