import java.util.*

class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        var answer: BooleanArray = BooleanArray(quiz.size){true}
        for((i,quiz) in quiz.withIndex()){
            val st = StringTokenizer(quiz)
            val first = st.nextToken().toInt()
            val oper = st.nextToken()
            val two = st.nextToken().toInt()
            st.nextToken()
            val result = st.nextToken().toInt()
            answer[i] = if(oper == "+"){
                first + two == result
            }else {
                first - two == result
            }
        }

        val arr = Array<String>(answer.size){if (answer[it]) "O" else "X"}
        return arr
    }
}