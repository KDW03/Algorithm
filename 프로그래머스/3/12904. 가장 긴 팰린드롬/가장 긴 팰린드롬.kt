class Solution {
    fun solution(s: String): Int {
        var maxPalindromeLength = 1

        for (center in 1 until s.length - 1) {
            var palindromeLength = 1
            var left = center - 1
            var right = center + 1
            while (left >= 0 && right <= s.lastIndex && s[left] == s[right]) {
                palindromeLength += 2
                left--
                right++
            }
            maxPalindromeLength = maxOf(maxPalindromeLength, palindromeLength)
        }
        
        for (left in 0 until s.length - 1) {
            if (s[left] != s[left + 1]) continue

            var palindromeLength = 2
            var right = left + 1
            var outerLeft = left - 1
            var outerRight = right + 1

            while (outerLeft >= 0 && outerRight <= s.lastIndex && s[outerLeft] == s[outerRight]) {
                palindromeLength += 2
                outerLeft--
                outerRight++
            }

            maxPalindromeLength = maxOf(maxPalindromeLength, palindromeLength)
        }

        return maxPalindromeLength
    }
}
