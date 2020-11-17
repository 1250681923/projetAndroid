package com.example.newsletter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsletter.data.service.ArticleOnlineService
import com.example.newsletter.data.service.FavoritsApiService
import com.example.newsletter.models.Article
import com.example.newsletter.models.ArticleResponse

@Database(entities = arrayOf(Article::class), version = 1)
abstract class FavoritsDatabase : RoomDatabase() {

    abstract fun FavoritsApiService(): FavoritsApiService

//    private val apiService: FavoritsApiService = FavoritsApiService()
//
//    fun onFavoritsArticle(article: Article) = apiService.insertArticle(article)
//    fun onRemoveFavArticle(id: Int) = apiService.deleteArticle(id)
//    fun getListArticlesFav() = apiService.getArticle()

    companion object {
        @Volatile
        private var INSTANCE: FavoritsDatabase? = null

        fun getInstance(context: Context): FavoritsDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                FavoritsDatabase::class.java, "Sample.db")
                .build()
    }

}