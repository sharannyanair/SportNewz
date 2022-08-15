package com.app.sportnewz

import com.app.sportnewz.sportdetails.SportsNewsViewData
import com.app.sportzdomain.data.ApiResponse
import com.app.sportzdomain.data.model.F1Results
import com.app.sportzdomain.data.model.NbaResults
import com.app.sportzdomain.data.model.ResponseEntity
import com.app.sportzdomain.data.model.Tennis

fun getSportViewData() =
    listOf(
        SportsNewsViewData("May 9 Sunday 12;55 PM",
        "Roland Garros: Rafael Nadal wins against Schwartzman in 3 sets")
    )

fun getApiResponse() =ApiResponse.success(getSportsNewsEntity())
fun getSportsNewsEntity() = ResponseEntity(
    arrayListOf(
        F1Results(
            "May 9 Sunday 12;55 PM",
            Double.MIN_VALUE,
            "tournament",
            "winner"

    )),
    arrayListOf(NbaResults(
        12,
        "looser",
        "mvp",
        "May 8 Sunday 12;55 PM",
        "tournament",
        "winner"
    )),
    arrayListOf(Tennis(
        "looser",
    3,
        "May 6 Sunday 12;55 PM",
        "tournament",
        "winner"
    )
    )
)