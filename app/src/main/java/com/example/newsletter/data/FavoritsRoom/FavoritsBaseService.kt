//package com.example.newsletter.data.service
//
//
//import android.content.Context
//import androidx.core.content.ContentProviderCompat.requireContext
//import com.example.newsletter.adapters.ListArticlesHandler
//import com.example.newsletter.data.FavoritsDatabase
//import com.example.newsletter.models.Article
//import java.net.URI.create
//
//class FavoritsBaseService: FavoritsService {
//
//    private val service.FavoritsApiService
//
//    init {
//        service.FavoritsApiService
//    }
//
//    override fun onFavoritsArticle(article: Article,context: Context) {
//        service.FavoritsApiService.insertArticle(article)
//    }
//
//    override fun onRemoveFavArticle(id: Int,context: Context) {
//        service.deleteArticle(id)
//    }
//
//    override fun getListArticlesFav(context: Context): List<Article> {
//        return service.getArticle()
//    }
//}
