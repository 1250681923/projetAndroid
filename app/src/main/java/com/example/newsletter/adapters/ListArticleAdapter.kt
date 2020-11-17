package com.example.newsletter.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsletter.MainActivity
import com.example.newsletter.R
import com.example.newsletter.models.Article
import kotlinx.coroutines.CoroutineScope

//val root: MainActivity
class ListArticlesAdapter(
    items: List<Article>,
    val handler: ListArticlesHandler
) : RecyclerView.Adapter<ListArticlesAdapter.ViewHolder>() {
    private val mArticle: List<Article> = items
    private var a: Int = 0

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


        if (isArticleFav(article)){
            holder.favorits.setBackgroundResource(R.drawable.ic_favorite_round_24)
        }
        else {
            holder.favorits.setBackgroundResource(R.drawable.ic_favorite_border_24)
        }
        holder.favorits.setOnClickListener{
            if (isArticleFav(article)){
                holder.favorits.setBackgroundResource(R.drawable.ic_favorite_border_24)
                handler.onRemoveFavArticle(article.id)
                //Toast.makeText(handler,"retiré des favoris", Toast.LENGTH_SHORT).show()
            }
            else {
                holder.favorits.setBackgroundResource(R.drawable.ic_favorite_round_24)
                a++
                article.id = a
                handler.onFavoritsArticle(article)
                //Toast.makeText(handler,"ajouté aux favoris", Toast.LENGTH_SHORT).show()
            }
            println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++ ${it}")
        }

    }

    fun isArticleFav(article: Article):Boolean{
        for (item: Article in handler.getListArticlesFav()){
            if (item.url == article.url) return true

        }
        return false

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
            favorits = view.findViewById(R.id.btn_favoris)
        }
    }

}