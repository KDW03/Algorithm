class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        var canSay = arrayOf("aya", "ye", "woo", "ma")
        for (say in babbling) {
            var temp = say
            for (can in canSay) {
                temp = temp.replace(can, " ")
            }
            if (temp.trim() == "")answer++
        }
        return answer
    }
}