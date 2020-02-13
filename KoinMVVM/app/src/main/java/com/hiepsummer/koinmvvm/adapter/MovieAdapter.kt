package com.hiepsummer.koinmvvm.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.hiepsummer.koinmvvm.data.MovieCollection
import com.hiepsummer.koinmvvm.viewholder.MovieAdapterViewHolder
import com.squareup.picasso.Picasso

class MovieAdapter(private val picasso: Picasso) :
    androidx.recyclerview.widget.ListAdapter<MovieCollection.Movie, MovieAdapterViewHolder>(
        DIFF_CALLBACK
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        MovieAdapterViewHolder.create(parent, picasso)

    override fun onBindViewHolder(holderAdapter: MovieAdapterViewHolder, position: Int) {
        holderAdapter.bind(getItem(position))
    }

    companion object {

        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieCollection.Movie>() {

            override fun areItemsTheSame(
                oldItem: MovieCollection.Movie,
                newItem: MovieCollection.Movie
            ) = oldItem.id == newItem.id

            override fun areContentsTheSame(
                oldItem: MovieCollection.Movie,
                newItem: MovieCollection.Movie
            ) =
                oldItem == newItem
        }
    }
}