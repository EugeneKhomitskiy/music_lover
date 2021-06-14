import kotlin.math.roundToInt

const val DISCOUNT_START = 1_000.0
const val DISCOUNT_START_PERCENT = 10_000.0
const val DISCOUNT = 100.0
const val DISCOUNT_PERCENT = 0.05
const val DISCOUNT_MOUNT = 0.01

fun main() {
    var totalPrice = 0.0

    while (true) {
        println("Введите сумму покупки:")
        val sum = readLine()!!.toDouble()

        /*val result = if (totalPrice > DISCOUNT_START && totalPrice <= DISCOUNT_START_PERCENT) {
            sum - DISCOUNT
        } else if (totalPrice > DISCOUNT_START_PERCENT) {
            sum - ((sum * DISCOUNT_PERCENT) * 100).roundToInt() /100
        } else sum */

        val result = when (totalPrice) {
            in DISCOUNT_START..DISCOUNT_START_PERCENT -> sum - DISCOUNT
            in DISCOUNT_START_PERCENT..totalPrice -> sum - ((sum * DISCOUNT_PERCENT) * 100).roundToInt() / 100
            else -> sum
        }

        val result1 = if (totalPrice != 0.00) result - (result * DISCOUNT_MOUNT) else result

        totalPrice += result1

        val str = result1.toString().split(".").toTypedArray()
        val rub = str[0]
        val penny = str[1]

        println("Сумма к оплате: $rub руб. $penny коп.\n")
    }
}