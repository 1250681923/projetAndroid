//package com.example.newsletter.data.service
//
//
//import androidx.core.content.ContentProviderCompat.requireContext
//import com.example.newsletter.adapters.ListArticlesHandler
//import com.example.newsletter.data.FavoritsDatabase
//import com.example.newsletter.models.Article
//import java.net.URI.create
//
//class FavoritsBaseService: FavoritsService {
//
//    private val service: FavoritsApiService
////
////    init {
////
////    }
//
//    override fun onFavoritsArticle(article: Article) {
//        FavoritsDatabase.getInstance(requireContext(context)).FavoritsApiService().insertArticle(article)
//    }
//
//    override fun onRemoveFavArticle(id: Int) {
//        service.deleteArticle(id)
//    }
//
//    override fun getListArticlesFav(): List<Article> {
//        return service.getArticle()
//    }
//}
