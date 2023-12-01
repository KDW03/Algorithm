class Solution {
        fun solution(s: String, skip: String, index: Int): String {
        val result = StringBuilder()

        for (char in s) {
            var newIndex = index
            var newChar = char

            while (newIndex > 0) {
                newChar++

                if (newChar > 'z') {
                    newChar = 'a'
                }

                if (!skip.contains(newChar)) {
                    newIndex--
                }
            }

            result.append(newChar)
        }

        return result.toString()
    }
}