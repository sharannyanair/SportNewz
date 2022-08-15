package com.app.sportnewz.sportdetails

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_sportz.view.*

class NewsViewHolder(private val itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    fun bind(newsData: SportsNewsViewData) {
        itemView.tv_news.text = newsData.news
    }
}