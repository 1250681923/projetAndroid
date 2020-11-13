package com.example.newsletter.data

import com.example.newsletter.data.service.ArticleOnlineService
import com.example.newsletter.models.Article

class ArticleRepository {
    private val apiService: ArticleOnlineService = ArticleOnlineService()

    fun getArticles(): List<Article> = apiService.getArticles()

    companion object {
        private var instance: ArticleRepository? = null
        fun getInstance(): ArticleRepository {
            if (instance == null) {
                instance = ArticleRepository()
            }
            return instance!!
        }
    }
}