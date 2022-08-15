package com.app.sportzdomain.data.model

import com.google.gson.annotations.SerializedName

data class ResponseEntity(

    @SerializedName("f1Results") var f1Results: ArrayList<F1Results> = arrayListOf(),
    @SerializedName("nbaResults") var nbaResults: ArrayList<NbaResults> = arrayListOf(),
    @SerializedName("Tennis") var tennisList: ArrayList<Tennis> = arrayListOf()

)