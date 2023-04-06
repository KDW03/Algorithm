import java.time.LocalDate

data class Date(var year: Int, var month: Int, var day: Int) {
    fun refreshDate(addMonth: Int): Date {
        var sum = month + addMonth
        if (sum > 12) {
            this.year += sum /12
            sum %= 12
        }
        this.month = sum
        if (this.month == 0) {
            this.month = 12
            this.year--
        }
        return this
    }

    fun compare(date: Date): Boolean = LocalDate.of(year, month, day) <= LocalDate.of(date.year, date.month, date.day)
}

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val answer: MutableList<Int> = mutableListOf()
        val map: Map<String, Int> = terms.associate { val str = it.split(" "); str[0] to str[1].toInt() }
        val todayDate = today.toDate()
        var num = 1
        for (pri in privacies) {
            val tmp = pri.split(" ")
            val date = tmp[0]
            val addMonth = map[tmp[1]]
            if (addMonth != null){
                if (date.toDate().refreshDate(addMonth).compare(todayDate)) answer.add(num)
            }
            num++
        }
        return answer.toIntArray()
    }

    private fun String.toDate(): Date {
        val tmp = this.split(".").map { it.toInt() }
        return Date(tmp[0], tmp[1], tmp[2])
    }
}
