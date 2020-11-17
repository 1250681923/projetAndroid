package com.example.newsletter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsletter.R
import com.example.newsletter.data.FavoritsDatabase
import com.example.newsletter.models.Article
import kotlinx.coroutines.CoroutineScope

class ListArticlesAdapter(
    items: List<Article>,
    val handler: ListArticlesHandler
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
        holder.content.text = article.content

        val context = holder.itemView
        //val context : Context = holder.mArticle.context
        // Display Neighbour Avatar
        Glide.with(context)
                .load(article.urlToImage)
                .apply(RequestOptions.circleCropTransform())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .skipMemoryCache(false)
                .into(holder.image)


        holder.favorits.setOnClickListener{
            handler.onFavoritsArticle(article)
        }


    }


    override fun getItemCount(): Int {
        return mArticle.size
    }

    class ViewHolder(view: View) :
            RecyclerView.ViewHolder(view) {
            val title: TextView
            val content: TextView
            val image: ImageView
            val favorits: Button
        init {
            title = view.findViewById(R.id.title)
            content = view.findViewById(R.id.content)
            image = view.findViewById(R.id.image)
            favorits = view.findViewById(R.id.btn_favories)
        }
    }

}