package com.example.newsletter.data.service

import com.example.newsletter.models.Article

interface ArticleService {
    fun getArticles(): List<Article>
}