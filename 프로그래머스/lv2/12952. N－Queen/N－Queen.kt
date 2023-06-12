class Solution {
    var answer = 0
    fun solution(n: Int): Int {
        var chess : Array<BooleanArray> = Array(n) { BooleanArray(n) }
        dfs(chess,0,0,n,0)
        return answer
    }

    fun dfs(chess : Array<BooleanArray>, x : Int, y : Int, n : Int, nowQ : Int){



        if(n == nowQ) {
            answer++
            for(c in chess){
                val a = c.joinToString()
                println(a)
            }
            println()
            return
        }

        // 4 >= 4
        if(x >= n || y >= n) return

        val tmp = Array(n) { chess[it].copyOf() }

        if(check(chess,x,y,n)) {
            dfs(chess,x,y,n,nowQ+1)
            dfs(chess,x,y,n,nowQ+1)
        }
        dfs(tmp,x+1,y,n,nowQ)
        dfs(tmp,x,y+1,n,nowQ)
    }


    fun check(chess : Array<BooleanArray> ,x : Int, y : Int, n : Int) = (checkUD(chess,n,y) && checkRL(chess,n,x) && checkRU(chess,n,x + y) && checkRD(chess,n,x - y))

    // 세로
    // i (0 until n)
    // [i][y]
    fun checkUD(chess : Array<BooleanArray>, n : Int , now : Int) : Boolean{
        for(i in 0 until n){
            if(chess[i][now]) return false
            chess[i][now] = true
        }
        return true
    }

    // 가로
    // i (0 until n)
    // [x][i]
    fun checkRL(chess : Array<BooleanArray>, n : Int , now : Int) : Boolean{
        for(i in 0 until n){
            if(chess[now][i]) return false
            chess[now][i] = true
        }
        return true
    }


    // when start (x + y  , y - y)    
    // 대각 Up -1,+1
    fun checkRU(chess : Array<BooleanArray>, n : Int , now : Int) : Boolean{
        var x = now
        var y = 0
        while(x < n && y < n){
            if(chess[x][y]) return false
            chess[x][y] = true
            x--
            y++
        }
        return true
    }

    // when start (x - y, y - y)
    // 대각 Down +1,+1
    fun checkRD(chess : Array<BooleanArray>, n : Int , now : Int) : Boolean{
        var x = now
        var y = 0
        while(x < n && y < n){
            if(chess[x][y]) return false
            chess[x][y] = true
            x++
            y++
        }
        return true
    }



}

fun main(){
    Solution().solution(4)
}