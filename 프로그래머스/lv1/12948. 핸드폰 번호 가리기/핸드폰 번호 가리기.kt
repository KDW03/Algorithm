class Solution {
    fun solution(phone_number: String): String = 
    phone_number.mapIndexed{ i , v -> if(i < phone_number.length - 4) '*' else v }.joinToString("")
}