package com.example.newsletter.data.service

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.newsletter.models.Article

interface FavoritsApiService {

    @Query("SELECT * FROM articles ")
    fun getArticle(): List<Article>

    /*当数据库中已经有此用户的时候，直接替换*/
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertArticle(article: Article)

    @Query("DELETE FROM articles")
    fun deleteArticle()
}