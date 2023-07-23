class Solution {
    lateinit var todayDate: Date

    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        todayDate = toDate(today)

        val tMap: HashMap<String, Date> = HashMap()

        terms.forEach {
            it.split(" ").let { t ->
                val term = t[1].toInt()
                val str = "${term / 12}.${term % 12}.${0}"
                tMap[t[0]] = toDate(str)
            }
        }

        return privacies.mapIndexedNotNull { index, s ->
            s.split(" ").let { t ->
                val tmp = toDate(t[0])
                tmp.addDate(tMap[t[1]]!!)
                if (isBigThanToday(tmp)) index + 1 else null
            }
        }.toIntArray()
    }
    private fun isBigThanToday(endDate: Date): Boolean = todayDate.isBig(endDate)
}


fun toDate(str: String): Date {
    val dateList = str.split(".").map { it.toInt() }
    return Date(dateList[0], dateList[1], dateList[2])
}


class Date(private var year: Int, private var month: Int, private var day: Int) {
    override fun toString(): String = "%04d.%02d.%02d".format(year, month, day)

    fun isBig(date: Date): Boolean {
        return this.toString() >= date.toString()
    }

    fun addDate(date: Date) {
        this.month += date.month
        this.year += date.year
        this.day += date.day

        if (this.month > 12) {
            this.year += this.month / 12
            this.month %= 12
        }
    }

}