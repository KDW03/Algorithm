class Solution {
    fun palindrome(s: String): Boolean {
    if (s.length <= 1) {
        return true
    }

    if (s.first() == s.last()) {
        return palindrome(s.substring(1, s.length - 1))
    } else {
        return false
    }
}

fun solution(s: String): Int {
    for (cut in s.length downTo 1) {
        for (start in 0 until s.length) {
            val cutStr = s.substring(start, start + cut)
            if (palindrome(cutStr)) {
                return cutStr.length
            }

            if (start + cut >= s.length) {
                break
            }
        }
    }
    return 0
}

}