class Solution {
    val map: HashMap<String, Int> = hashMapOf()

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer: Array<String> = arrayOf<String>()

        val maxlen = orders.maxOf { it.length }
        val filterCourse =  course.filter { it <= maxlen } 
        orders.forEach { order ->
            filterCourse.forEach { count ->
                combination(order.toCharArray().sorted().joinToString(""), count)
            }
        }
        val list = map.filter { it.value >= 2 }
        var answerList: MutableList<String> = mutableListOf()
        filterCourse.forEach { count ->
            val countList = list.filter { it.key.length == count }
            
            val max = countList.map { it.value }.maxOrNull()
            answerList.addAll(countList.filter { it.value == max!! }.map { it.key })
        }

        return answerList.sorted().toTypedArray()
    }

    fun combination(order: String, count: Int, i: Int = 0, newMenu: String = "") {
        if(count == newMenu.length) {
            map[newMenu] = map.getOrDefault(newMenu,0) + 1
            return
        }
        if(i >= order.length) return

        combination(order, count, i + 1, newMenu + order[i])
        combination(order, count, i + 1, newMenu)
    }

}