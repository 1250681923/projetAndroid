package com.example.newsletter.data

import com.example.newsletter.data.service.ArticleOnlineService
import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleResponse

class ArticleRepository {
    private val apiService: ArticleOnlineService = ArticleOnlineService()

    fun getArticles(q:String): ArticleResponse = apiService.getArticles(q)
    fun getArticlesByCountry(country:String): ArticleResponse = apiService.getArticlesByCountry(country)
    fun getArticlesByCategory(country: String, category: String) = apiService.getArticlesByCategory(country, category)
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