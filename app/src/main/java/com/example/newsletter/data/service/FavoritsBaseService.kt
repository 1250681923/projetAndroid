package com.example.newsletter.data.service


import com.example.newsletter.adapters.ListArticlesHandler
import com.example.newsletter.models.Article
import java.net.URI.create

class FavoritsBaseService: FavoritsService {
    private val service: FavoritsApiService

    init {
        service : FavoritsApiService
    }

    override fun onFavoritsArticle(article: Article) {
        service.insertArticle(article)
    }

    override fun onRemoveFavArticle(id: Int) {
        service.deleteArticle(id)
    }

    override fun getListArticlesFav(): List<Article> {
        return service.getArticle()
    }
}
