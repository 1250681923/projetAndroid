package com.example.newsletter.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor
@Entity(tableName = "articles")
data class Article (
        @PrimaryKey
        val author: String,
        val title: String,
        val description: String,
        val urlToImage: String,
        val url:String,
        val publishedAt: String,
        val content: String
)


data class ArticleResponse(
        val status:String,
        val totalResults: Int,
        val articles: List<Article>
)