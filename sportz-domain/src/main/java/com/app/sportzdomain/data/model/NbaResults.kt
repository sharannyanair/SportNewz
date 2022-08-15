package com.app.sportzdomain.data.model

import com.google.gson.annotations.SerializedName


data class NbaResults(

    @SerializedName("gameNumber") var gameNumber: Int? = null,
    @SerializedName("looser") var looser: String? = null,
    @SerializedName("mvp") var mvp: String? = null,
    @SerializedName("publicationDate") var publicationDate: String? = null,
    @SerializedName("tournament") var tournament: String? = null,
    @SerializedName("winner") var winner: String? = null

)