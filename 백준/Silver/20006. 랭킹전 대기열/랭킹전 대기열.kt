import kotlin.math.abs

data class Bang(val maxUserCount: Int, val users: ArrayList<User> = arrayListOf()) {
    fun enterUser(user: User): Boolean {
        return if (users.size < maxUserCount && abs((users.firstOrNull()?.level ?: user.level) - user.level) <= 10) {
            users.add(user)
            true
        } else false
    }
}

data class User(val level: Int, val name: String) {
    override fun toString(): String = "$level $name"
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (p, m) = br.readLine().split(" ").map { it.toInt() }
    val bangList = ArrayList<Bang>()


    repeat(p) {
        val (level, name) = br.readLine().split(" ")
        val user = User(level.toInt(), name)
        val result = bangList.firstOrNull { it.enterUser(user) }
        if (result == null) {
            val newBang = Bang(m)
            newBang.enterUser(user)
            bangList.add(newBang)
        }
    }

    val sb = StringBuilder()

    bangList.forEach {
        if (it.users.size == m) {
            sb.append("Started!").append("\n")
        } else {
            sb.append("Waiting!").append("\n")
        }

        it.users.sortedBy { user -> user.name }.forEach { sortedUser ->
            sb.append(sortedUser.toString()).append("\n")
        }
    }

    println(sb.toString())
}

