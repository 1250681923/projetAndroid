package com.example.newsletter.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.models.Article

class ListArticlesAdapter(
        items: List<Article>
) : RecyclerView.Adapter<ListArticlesAdapter.ViewHolder>() {
    private val mArticle: List<Article> = items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article: Article = mArticle[position]
        // Display Neighbour Name
        holder.title.text = article.title
    }

    override fun getItemCount(): Int {
        return mArticle.size
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
            val title: TextView
            val description: TextView
            val image: ImageView
        init {
            title = view.findViewById(R.id.title)
            description = view.findViewById(R.id.description)
            image = view.findViewById(R.id.image)
        }
    }

}