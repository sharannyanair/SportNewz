package com.app.sportzdomain.data.model

import com.google.gson.annotations.SerializedName


data class F1Results(

    @SerializedName("publicationDate") var publicationDate: String? = null,
    @SerializedName("seconds") var seconds: Double? = null,
    @SerializedName("tournament") var tournament: String? = null,
    @SerializedName("winner") var winner: String? = null

)