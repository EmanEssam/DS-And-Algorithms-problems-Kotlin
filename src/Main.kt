//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {


    val myArray = MyArray<Int>()
    println(myArray.length)

    myArray.push(1)
    myArray.push(2)
    myArray.printArray()
    myArray.pop()
    myArray.pop()
    myArray.pop()
    myArray.push(4)
    myArray.push(5)
    myArray.push(6)
    myArray.push(7)
    myArray.printArray()
    myArray.delete(1)
    myArray.printArray()
    println(myArray.length)
    println(reverseString("eman"))
    println(mergeSortedArrays(intArrayOf(), intArrayOf(4, 5, 6)).contentToString())
}

fun reverseString(s: String): String {
    var result = StringBuilder(s.length)
    for (i in s.length - 1 downTo 0) {
        result.append(s[i])
    }
    return result.toString()

}

fun mergeSortedArrays(array1: IntArray, array2: IntArray): IntArray {

    val newArray = IntArray(size = array1.size + array2.size)
    var i = 0
    var j = 0
    var k = 0


    if (array1.isEmpty()) return array2
    if (array2.isEmpty()) return array1

    while (i < array1.size && j < array2.size) {

        if (array1[i] < array2[j]) {
            newArray[k++] = array1[i++]
        } else {
            newArray[k++] = array2[j++]
        }
    }

    while (i < array1.size) {
        newArray[k++] = array1[i++]
    }
    while (j < array2.size) {
        newArray[k++] = array2[j++]
    }


    return newArray
}


