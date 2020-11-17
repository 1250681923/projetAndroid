package com.example.newsletter.adapters

import com.example.newsletter.models.Article

interface ListArticlesHandler {
    fun onFavoritsArticle(article: Article)
}