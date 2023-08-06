import kotlin.math.abs

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        val keypad = " 123456789*0#"
        var right = keypad.indexOf('*')
        var left = keypad.indexOf('#')
        return numbers.map {
            val nowHand = when (it) {
                1, 4, 7 -> {
                    'L'
                }
                3, 6, 9 -> {
                    'R'
                }
                else -> {
                    val t = keypad.indexOf(it.digitToChar())
                    val l = abs(t - left)
                    val r = abs(t - right)
                    if ((l / 3) + (l % 3) < (r / 3) + (r % 3)) {
                        'L'
                    } else if ((l / 3) + (l % 3) > (r / 3) + (r % 3)) {
                        'R'
                    } else {
                        if (hand == "right") {
                            'R'
                        } else {
                            'L'
                        }
                    }
                }
            }
            if (nowHand == 'R') right = keypad.indexOf(it.digitToChar()) else left = keypad.indexOf(it.digitToChar())
            nowHand
        }.joinToString("")
    }
}