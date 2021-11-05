package com.volohov.chucknorrisjokes.api

import com.google.gson.annotations.SerializedName

object ApiDataModel {
    data class Jokes(
        @SerializedName("type") val requestType: String,
        @SerializedName("value") val value: List<HashMap<String, Any>>
    )
}
