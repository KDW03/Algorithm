class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var right = 0
        var left = 0
        return numbers.map {
            when (it) {
                1, 4, 7 -> {
                    left = it
                    'L'
                }
                3, 6, 9 -> {
                    right = it
                    'R'
                }

                else -> {
                    var t = it
                    var r = 0
                    var l = 0

                    if (it == 0){
                        t = 8
                    }

                    if (right == 0){
                        right = 8
                        r++
                    }

                    if (left == 0){
                        left = 8
                        l++
                    }

                    l = t - left
                    r = t - right

                    if ((l / 3) + (l % 3) > (r / 3) + (r % 3)) {
                        left = it
                        'L'
                    } else if ((l / 3) + (l % 3) < (r / 3) + (r % 3)) {
                        right = it
                        'R'
                    } else {
                        if (hand == "right") 'R' else 'L'
                    }
                }
            }
        }.joinToString("")
    }
}