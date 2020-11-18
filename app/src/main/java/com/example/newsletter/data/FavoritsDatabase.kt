package com.example.newsletter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsletter.data.service.FavoritsBaseService
import com.example.newsletter.models.Article

@Database(entities = arrayOf(Article::class), version = 1)
abstract class FavoritsDatabase : RoomDatabase() {

//    abstract fun FavoritsApiService(): FavoritsApiService
    private val apiService: FavoritsBaseService = FavoritsBaseService()

    fun onFavoritsArticle(article: Article) = apiService.onFavoritsArticle(article)
    fun onRemoveFavArticle(id: Int) = apiService.onRemoveFavArticle(id)
    fun getListArticlesFav() = apiService.getListArticlesFav()

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