package com.example.newsletter.data.service

import android.content.Context
import com.example.newsletter.models.Article

interface FavoritsService {


    fun onFavoritsArticle(article: Article, context: Context)
    fun onRemoveFavArticle(id: Int, context: Context)
    fun getListArticlesFav(context: Context): List<Article>
}