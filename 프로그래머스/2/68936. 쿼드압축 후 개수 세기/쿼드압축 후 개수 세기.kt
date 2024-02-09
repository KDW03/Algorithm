class Solution {
    fun solution(arr: Array<IntArray>): IntArray {

        val n = arr.size

        fun makeQuardTree(partN : Int, startX : Int, startY : Int) : IntArray {
            val answer = IntArray(2)
            val first = arr[startX][startY]
            if(partN == 1) {
                answer[first] = 1
                return answer
            } 

            var flag = true

            outer@for(x in startX until startX + partN) {
                for(y in startY until startY + partN) {
                    if(arr[x][y] != first) {
                        flag =false
                        break@outer
                    }
                }
            }

            if(flag) answer[first] = 1 else {
                val newN = partN / 2

                val leftUp = makeQuardTree(newN , startX, startY)
                val rightUp = makeQuardTree(newN , startX + newN, startY)
                val leftDown = makeQuardTree(newN , startX , startY + newN)
                val rightDown = makeQuardTree(newN , startX + newN, startY + newN)

                for(i in 0 until 2) {
                    answer[i] = answer[i] + leftUp[i] + rightUp[i] + leftDown[i] + rightDown[i]
                }
            }
            return answer
        }

        return makeQuardTree(n,0,0)
    }
}