class Solution {
    fun solution(n: Int): Int {
        return getQueen(n,0,Chess(n))
    }


    fun getQueen(n : Int, row : Int, chess : Chess) : Int {
        return if(n == row) 1
        else{
            var count = 0
            for(i in 0 until n){
                if(chess.isAvailableQueen(row,i)){
                    count += getQueen(n, row + 1, chess.copy().apply{
                        queens.add(Queen(row,i))
                    })
                }
            }
            count
        }
    }



    class Chess(val n : Int, val queens : ArrayList<Queen> = arrayListOf()){
        fun isAvailableQueen(row : Int, col : Int) : Boolean{
            for(queen in queens){
                if(queen.row == row) return false
                if(queen.col == col) return false
                if(Math.abs(queen.row - row) == Math.abs(queen.col - col)) return false
            }
            return true
        }
        fun copy() = Chess(n, ArrayList(queens))
    }



    class Queen(val row: Int, val col : Int)
}