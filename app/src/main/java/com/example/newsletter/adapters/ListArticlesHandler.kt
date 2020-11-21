package com.example.newsletter.adapters

import android.view.View
import com.example.newsletter.models.Article

interface ListArticlesHandler {
    fun onFavoritsArticle(article: Article)
    fun onRemoveFavArticle(article: Article)
    //fun onRemoveFavArticle(id: Int)
    fun getListArticlesFav(): List<Article>
    fun seeDetails(article: Article, context: View)
}