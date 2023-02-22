class Solution {
    fun solution(my_string: String): String {
        val sb = StringBuilder()
        for(char in my_string){
            var tmp = ""
            if(char >= 'a' && char <= 'z'){
                tmp = char.uppercase()
            }else{
                tmp = char.lowercase()
            }
            sb.append(tmp)
        }
        return sb.toString()
    }
}