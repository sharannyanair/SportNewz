package com.app.sportzdomain.data.model

import com.google.gson.annotations.SerializedName


data class Tennis(

    @SerializedName("looser") var looser: String? = null,
    @SerializedName("numberOfSets") var numberOfSets: Int? = null,
    @SerializedName("publicationDate") var publicationDate: String? = null,
    @SerializedName("tournament") var tournament: String? = null,
    @SerializedName("winner") var winner: String? = null

)