package com.example.myapplication.model

import com.google.gson.annotations.SerializedName

class Senator(
    val description: String = "",
    val person: Person = Person("", ""),
    @SerializedName("leadership_title")
    val leadershipTitle: String = "",
    val website: String = ""
) : Comparable<Senator> {
    override fun compareTo(other: Senator): Int =
        this.person.lastname.compareTo(other.person.lastname)
}
