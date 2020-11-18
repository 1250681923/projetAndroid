//package com.example.newsletter.data.service
//
//import androidx.room.*
//import com.example.newsletter.models.Article
//@Dao
//interface FavoritsApiService {
//
//
//    @Query("SELECT * FROM articles")
//    fun getArticle(): List<Article>
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insertArticle(article: Article)
//
//    @Query("DELETE FROM articles WHERE id = :id")
//    fun deleteArticle(id: Int)
//}
//
