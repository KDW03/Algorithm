import java.util.*
import kotlin.jvm.Throws


class Solution {

    fun solution(p: String): String = first(p)


    fun first(s: String): String {
        if (s == "") return s
        var openCount = 0
        var closeCount = 0
        var splitIdx = 0
        for(i in s.indices){
            val char = s[i]
            if(char == '(') openCount++
            if(char == ')') closeCount++
            if(openCount == closeCount) {
                splitIdx = i
                break
            }
        }
        val u = s.substring(0 .. splitIdx)
        val v = s.substring(splitIdx+1)
        return if (isCollect(u)) {
            // 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행
            //수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
            u + first(v)
        } else {
            return "(" + first(v) + ")" + u.drop(1).dropLast(1).map {
                when(it){
                    '(' -> ')'
                    ')' -> '('
                    else ->{}
                }
            }.joinToString("")
        }
    }

    // 올바른 문자인지
    fun isCollect(s: String): Boolean {
        if(s.length % 2 != 0 || s.length <= 1) return false 
        val stack: Stack<Int> = Stack()
        for (char in s) {
            when (char) {
                '(' -> {
                    stack.push(0)
                }

                ')' -> {
                    if (stack.isNotEmpty()) stack.pop()
                    else return false
                }
                else -> {
                    return false
                }
            }
        }
        return true
    }
}