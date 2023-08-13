class Solution {
    fun solution(s: String): String {
       return s.split(" ").map{ if(it == "") "" else it[0].toUpperCase() + it.substring(1).toLowerCase() }.joinToString(" ")   
    }
}