package com.app.sportnewz.sportdetails

import com.app.sportzdomain.data.model.ResponseEntity
import javax.inject.Inject

/**
 * Mapper class to convert response object to ui object
 */
class SportsDataMapper @Inject constructor() {
    fun mapFrom(responseEntity: ResponseEntity): ArrayList<SportsNewsViewData> {
        val list = ArrayList<SportsNewsViewData>()

        responseEntity.f1Results.forEach{
            val data : SportsNewsViewData =
                it.publicationDate?.let {
                        date ->
                    SportsNewsViewData(
                        date,
                        it.winner + " wins " + it.tournament + " by " + it.seconds)
                }!!
            list.add(data)
        }
        responseEntity.nbaResults.forEach {

            val data : SportsNewsViewData =
                it.publicationDate?.let {
                        date ->
                    SportsNewsViewData(
                        date,
                        it.mvp + " leads " + it.winner + " to game "+it.gameNumber +" win in the " + it.tournament)
                }!!
            list.add(data)}
        responseEntity.tennisList.forEach{
            val data : SportsNewsViewData =
                it.publicationDate?.let {
                        date ->
                    SportsNewsViewData(
                        date,
                        it.tournament +": "+ it.winner+" wins against "+it.looser + " in "+it.numberOfSets+" sets")
                }!!
            list.add(data)
            }
        list.sortByDescending { it.publicationDate }
        return list
    }
}