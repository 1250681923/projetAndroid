package com.example.newsletter.data.FavoritsLocal

import com.example.newsletter.models.Article


interface FavoritsApiService {

        val articles: List<Article>

        fun deleteFavorit(article: Article)

        fun createFavorit(article: Article)
}
