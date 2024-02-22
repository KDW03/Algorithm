class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        val map: HashMap<String, HashMap<String, Int>> = hashMapOf()
        val answerMap: HashMap<String, Int> = hashMapOf()
        val giftScoreMap: HashMap<String, Int> = hashMapOf()


        gifts.forEach {
            val tmp = it.split(" ")
            val a = tmp[0]
            val b = tmp[1]
            if (map[a] == null) map[a] = hashMapOf()
            map[a]!![b] = map[a]!!.getOrDefault(b, 0) + 1

            // a는 선물 지수 +1 , b는 선물지수 -1
            giftScoreMap[a] = giftScoreMap.getOrDefault(a, 0) + 1
            giftScoreMap[b] = giftScoreMap.getOrDefault(b, 0) - 1
        }


        for (i in 0 until friends.size - 1) {
            for (j in i + 1 until friends.size) {
                val a = friends[i]
                val b = friends[j]
                var aTob = 0
                var bToa = 0

                if (map[a] != null) aTob = map[a]!!.getOrDefault(b, 0)
                if (map[b] != null) bToa = map[b]!!.getOrDefault(a, 0)

                if (aTob > bToa) {
                    answerMap[a] = answerMap.getOrDefault(a, 0) + 1
                } else if (bToa > aTob) {
                    answerMap[b] = answerMap.getOrDefault(b, 0) + 1
                } else {
                    val aScore = giftScoreMap.getOrDefault(a, 0)
                    val bScore = giftScoreMap.getOrDefault(b, 0)

                    // b가 a한테 준다
                    if (aScore > bScore) {
                        answerMap[a] = answerMap.getOrDefault(a, 0) + 1
                    } else if (bScore > aScore) {
                        answerMap[b] = answerMap.getOrDefault(b, 0) + 1
                    }
                }

            }
        }

        return answerMap.values.maxOfOrNull { it } ?: 0
    }
}