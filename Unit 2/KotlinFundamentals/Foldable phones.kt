open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }
    
    fun switchOff() {
        isScreenLightOn = false
    }
    
    fun checkPhoneScreenLight() {
        val phoneScreenLight = if (isScreenLightOn) "on" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}

    
class FoldablePhone(isScreenLightOn: Boolean = false, var isFolded: Boolean = false): Phone(isScreenLightOn) {
    override fun switchOn() {
        if (isFolded) {
            isScreenLightOn = true
            println("The phone is unfolded, screen is now on.")
        } else {
            println("The phone is folded. The screen won't turn on.")
        }
    }
    
        // Thay đổi trạng thái gập/mở của điện thoại
    fun fold() {
        isFolded = true
        println("The phone is now folded.")
    }

    fun unfold() {
        isFolded = false
        println("The phone is now unfolded.")
    }
}

fun main() {
    // Tạo một đối tượng FoldablePhone
    val myFoldablePhone = FoldablePhone()

    // Kiểm tra trạng thái màn hình
    myFoldablePhone.checkPhoneScreenLight() // Output: The phone screen's light is off.

    // Thử bật màn hình khi điện thoại chưa gập
    myFoldablePhone.unfold()
    myFoldablePhone.switchOn()  // Output: The phone is unfolded, screen is now on.
    myFoldablePhone.checkPhoneScreenLight() // Output: The phone screen's light is on.

    // Gập điện thoại
    myFoldablePhone.fold()
    myFoldablePhone.switchOn()  // Output: The phone is folded. The screen won't turn on.

    // Tắt màn hình khi điện thoại đang gập
    myFoldablePhone.switchOff()
    myFoldablePhone.checkPhoneScreenLight() // Output: The phone screen's light is off.
}