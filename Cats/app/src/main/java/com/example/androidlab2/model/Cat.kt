package com.example.androidlab2.model

import com.google.gson.annotations.SerializedName

data class Cat(
    val length: String,
    val origin: String,
    @SerializedName("image_link") val imageLink: String,
    @SerializedName("family_friendly") val familyFriendly: Int,
    val shedding: Int,
    @SerializedName("general_health") val generalHealth: Int,
    val playfulness: Int,
    @SerializedName("children_friendly") val childrenFriendly: Int,
    val grooming: Int,
    val intelligence: Int,
    @SerializedName("other_pets_friendly") val otherPetsFriendly: Int,
    @SerializedName("min_weight") val minWeight: Int,
    @SerializedName("max_weight") val maxWeight: Int,
    @SerializedName("min_life_expectancy") val minLifeExpectancy: Int,
    @SerializedName("max_life_expectancy") val maxLifeExpectancy: Int,
    val name: String
)