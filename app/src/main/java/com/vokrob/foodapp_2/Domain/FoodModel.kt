package com.vokrob.foodapp_2.Domain

import java.io.Serializable

data class FoodModel(
    var BestFood: Boolean = false,
    var CategoryId: String = "",
    var Description: String = "",
    var Id: Int = 0,
    var ImagePath: String = "",
    var LocationId: Int = 0,
    var Price: Double = 0.0,
    var PriceId: Int = 0,
    var Star: Double = 0.0,
    var TimeId: Int = 0,
    var TimeValue: Int = 0,
    var Title: String = "",
    var Calories: Int = 0,
    var numberInCart: Int = 0
) : Serializable































