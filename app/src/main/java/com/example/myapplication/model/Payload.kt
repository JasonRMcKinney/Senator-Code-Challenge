package com.example.myapplication.model

data class Payload(
    val objects: Array<Senator>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Payload

        if (!objects.contentEquals(other.objects)) return false

        return true
    }

    override fun hashCode(): Int {
        return objects.contentHashCode()
    }
}

