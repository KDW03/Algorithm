class Solution {
    fun solution(n: Int): Int {
        val table : IntArray = IntArray(100001){-1}
        table[0] = 0
        table[1] = 1
        return f(n,table).toInt() 
    }
    
    fun f(n : Int,table : IntArray) : Int {
        if(table[n] == -1) table[n] = (f(n-1,table) + f(n-2,table)) % 1234567
        return table[n]
    }
}