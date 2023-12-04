class Solution {
    fun solution(topping: IntArray): Int {
        val totalToppings = topping.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        val currentToppings = mutableMapOf<Int, Int>()
        var count = 0

        topping.dropLast(1).forEach { top ->
            currentToppings[top] = currentToppings.getOrDefault(top, 0) + 1
            totalToppings[top] = totalToppings[top]!! - 1
            if (totalToppings[top] == 0) totalToppings.remove(top)

            if (currentToppings.size == totalToppings.size) count++
        }

        return count
    }
}