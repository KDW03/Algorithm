class Solution {
    fun solution(rsp: String): String  = rsp.map{  char ->
        when(char){
            '2' -> '0'
            '0' -> '5'
            else -> '2'        
        }
    }.joinToString("")
}