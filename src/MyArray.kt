class MyArray<T>(
    private var arr: Array<Any?> = arrayOfNulls(1),
    private var capacity: Int = 0,
    var length: Int = 0
) {

    @Suppress("UNCHECKED_CAST")
    fun get(index: Int): T {
        if (index in 0 until length) return arr[index] as T
        throw IndexOutOfBoundsException()
    }


    fun push(item: T) {

        if (capacity == length) {
            val newArr = arrayOfNulls<Any>(capacity * 2)

            for (i in arr.indices) {
                newArr[i] = arr[i] as Any
            }
            arr = newArr
            capacity = capacity * 2
            arr[length] = item
            length++
        }
    }



}




