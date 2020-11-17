package com.example.newsletter.adapters

import com.example.newsletter.models.Article

interface ListArticlesHandler {
    fun onFavoritsArticle(article: Article)
    fun onRemoveFavArticle(id: Int)
    fun getListArticlesFav(): List<Article>
}