package com.example.movies2020.ui.main

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.movies2020.R
import com.example.movies2020.model.Movie
import com.example.movies2020.navigaiton.Navigation
import kotlinx.android.synthetic.main.item_movie.view.*
import java.util.zip.Inflater

/**
 * Created by Duy M. Nguyen on 4/30/2020.
 */
class MovieAdapter(
    private val activity: Activity,
    private val listMovie: MutableList<Movie>
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivPoster: ImageView = itemView.iv_poster
        val tvTitle: TextView = itemView.tv_title
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_movie, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = listMovie[position]

        Glide
            .with(activity)
            .load(movie.poster)
            .into(holder.ivPoster)

        holder.tvTitle.text = movie.title

        holder.itemView.setOnClickListener {
            Navigation.toMovieActivity(activity, movie.imdbID ?: "")
        }
    }

    public fun addMovie(listMovie: MutableList<Movie>) {
        this.listMovie.addAll(listMovie)
        notifyDataSetChanged()
    }
}