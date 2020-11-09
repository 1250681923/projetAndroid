package com.example.newsletter.models

import java.io.FileDescriptor

data class Article (
        val author: String,
        val title: String,
        val description: String,
        val urlToImage: String,
        val publishedAt: String,
        val content: String
)