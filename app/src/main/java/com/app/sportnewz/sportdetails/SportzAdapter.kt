package com.app.sportnewz.sportdetails

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.sportnewz.databinding.ItemSportzBinding

/**
 * RecyclerView Adapter to display *Sports news*.
 *
 * @property data the list of news in this Adapter.
 */

class SportzAdapter(
    private val data: ArrayList<SportsNewsViewData>,
) : RecyclerView.Adapter<NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {

        val view =
            ItemSportzBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(view.root)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }


    /**
     * Method to update the data set of adapter.
     */

    fun update(list: ArrayList<SportsNewsViewData>) {
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }
}
