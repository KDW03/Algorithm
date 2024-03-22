class Solution {
    fun solution(board: Array<String>): Int {
        
        val boardStr = board.joinToString("")
        
        var oCount = 0
        var xCount = 0
        
        boardStr.forEach { c ->
            if(c == 'O') oCount++
            if(c == 'X') xCount++
        }

        if(oCount >= xCount + 2 || oCount < xCount) {
            return 0
        }
        
        
        val checkList = arrayOf(
            arrayOf(0,1,2),
            arrayOf(3,4,5),
            arrayOf(6,7,8),
            arrayOf(0,3,6),
            arrayOf(1,4,7),
            arrayOf(2,5,8),
            arrayOf(0,4,8),
            arrayOf(2,4,6)
        )
        
        
        val a = checkList.any { list ->
            list.all { boardStr[it] == 'O' }
        }
        
        val b = checkList.any { list ->
            list.all { boardStr[it] == 'X' }
        }
        
        if(a && b) return 0
        if(a && oCount != xCount + 1) return 0
        if(b && oCount != xCount) return 0
        
        return 1
    }
}


// O의 개수가 X보다 2개 이상 많거나 또는 O의 개수가 X보다 적다면 false

// 게임이 끝난 상황
// O 가 이긴 상황은 O가 하나 더 많아야함
// X 가 이긴 상황은 O와 X의 개수가 같아야함
// 그리고
// O 및 X가 동시에 이기는 상황은 없음
