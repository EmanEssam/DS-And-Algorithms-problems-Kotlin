class HashTable<K, V>(private val capacity: Int = 16) {

    // Data class for key-value pairs
    data class Entry<K, V>(val key: K, var value: V)

    // Array of mutable lists (each index stores multiple entries in case of collisions)
    private val buckets: Array<MutableList<Entry<K, V>>> = Array(capacity) { mutableListOf() }

    // Hash function to get index
    private fun hash(key: K): Int {
        return (key?.hashCode() ?: 0) % capacity
    }

    // Insert or update a key-value pair
    fun put(key: K, value: V) {
        val index = hash(key)
        val bucket = buckets[index]

        // If key exists, update the value
        for (entry in bucket) {
            if (entry.key == key) {
                entry.value = value
                return
            }
        }

        // Otherwise, add new entry
        bucket.add(Entry(key, value))
    }

    // Retrieve a value by key
    fun get(key: K): V? {
        val index = hash(key)
        val bucket = buckets[index]

        for (entry in bucket) {
            if (entry.key == key) {
                return entry.value
            }
        }

        return null
    }

    // Remove a key-value pair
    fun remove(key: K): Boolean {
        val index = hash(key)
        val bucket = buckets[index]

        val iterator = bucket.iterator()
        while (iterator.hasNext()) {
            val entry = iterator.next()
            if (entry.key == key) {
                iterator.remove()
                return true
            }
        }
        return false
    }

    // Print all entries (for debugging)
    fun printTable() {
        for (i in buckets.indices) {
            if (buckets[i].isNotEmpty()) {
                println("Bucket $i: ${buckets[i]}")
            }
        }
    }
}
