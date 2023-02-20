class Solution {
    fun solution(my_str: String, n: Int): Array<String> {
        val size = if (my_str.length % n == 0) my_str.length/n else (my_str.length/n)+1
        var answer: Array<String> = Array<String>(size){""}
        var index = 0
        for(i in my_str.indices step n){
            if (i+n >= my_str.length){
                answer[index++] = my_str.substring(i)
                break
            }
            answer[index++] = my_str.substring(i,i+n)
        }
        return answer
    }
}