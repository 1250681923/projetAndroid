package com.example.newsletter.fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.newsletter.R
import com.example.newsletter.data.FavoritsLocal.FavoritsRepository
import com.example.newsletter.models.Article
class ArticleDetailsInforFragment(article: Article, context: View): Fragment() {
    private val article:Article = article
    private val context: View = context
    private lateinit var image:ImageView
    private lateinit var title: TextView
    private lateinit var author: TextView
    private lateinit var url: TextView
    private lateinit var Description: TextView
    private lateinit var content:TextView
    private lateinit var publishedAt: TextView
    private lateinit var back : Button
    private lateinit var favor: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.article_details_fragment, container, false)
        image = view.findViewById(R.id.imageView)
        title = view.findViewById(R.id.title)
        author = view.findViewById(R.id.author)
        url = view.findViewById(R.id.URL)
        Description = view.findViewById(R.id.Description)
        content =view.findViewById(R.id.content)
        publishedAt = view.findViewById(R.id.publishedAt)
        back = view.findViewById(R.id.Back)
        favor = view.findViewById(R.id.favorit)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(context)
            .load(article.urlToImage)
            .apply(RequestOptions.circleCropTransform())
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
            .skipMemoryCache(false)
            .into(image)
        title.text = article.title
        author.text = article.author
        url.text = article.url
        Description.text = article.description
        content.text = article.content
        publishedAt.text =article.publishedAt
        back.setOnClickListener {
            activity?.onBackPressed()
        }

        if (isArticleFav(article)){
            favor.setBackgroundResource(R.drawable.ic_favorite_round_24)
        }
        else {
            favor.setBackgroundResource(R.drawable.ic_favorite_border_24)
        }
        favor.setOnClickListener{
            if (isArticleFav(article)){
                favor.setBackgroundResource(R.drawable.ic_favorite_border_24)
                FavoritsRepository.getInstance().remove(article)
            }
            else {
                favor.setBackgroundResource(R.drawable.ic_favorite_round_24)
                FavoritsRepository.getInstance().createFavorit(article)
            }
        }
    }
    fun isArticleFav(article: Article):Boolean{
        for (item: Article in  FavoritsRepository.getInstance().getFavorit()){
            if (item.url == article.url) return true
        }
        return false
    }

}