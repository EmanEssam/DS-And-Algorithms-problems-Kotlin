class MyArray<T>(
    private var arr: Array<Any?> = arrayOfNulls(1),
    private var capacity: Int = 1,
    var length: Int = 0
) {

    @Suppress("UNCHECKED_CAST")
    operator fun get(index: Int): T {
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
            capacity *= 2
        }
        arr[length] = item
        length++

    }

    fun pop() {
        if (length > 0) {
            arr[length - 1] = null
            length--
        }
    }

    fun printArray() {
        println(arr.contentToString())
    }

    fun delete(index: Int) {
        if (index < 0 || index >= length) throw IndexOutOfBoundsException()
        for (i in index until length-1) {
            arr[i] = arr[i + 1]
        }
            arr[length-1] = null
            length--
        }
    }





