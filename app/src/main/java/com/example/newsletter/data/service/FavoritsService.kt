package com.example.newsletter.data.service

import com.example.newsletter.models.Article

interface FavoritsService {
    fun onFavoritsArticle(article: Article)
    fun onRemoveFavArticle(id: Int)
    fun getListArticlesFav(): List<Article>
}