package com.example.newsletter.data.FavoritsLocal

import com.example.newsletter.models.Article

class FavoritsRepository {
    private val apiService: FavoritsApiService

    init {
        apiService = DummyFavoritsApiService()
    }

    fun getFavorit(): List<Article> = apiService.articles

    fun remove(article: Article) = apiService.deleteFavorit(article)

    fun createFavorit(article: Article) = apiService.createFavorit(article)

    companion object {
        private var instance: FavoritsRepository? = null
        fun getInstance(): FavoritsRepository {
            if (instance == null) {
                instance = FavoritsRepository()
            }
            return instance!!
        }
    }
}