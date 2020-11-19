package com.example.newsletter.data.FavoritsLocal

import com.example.newsletter.models.Article

class DummyFavoritsApiService: FavoritsApiService {

    override val articles: List<Article>
        get() = DUMMY_Articles

    override fun deleteFavorit(article: Article) {
        DUMMY_Articles.remove(article)
    }

    override fun createFavorit(article: Article) {
        DUMMY_Articles.add(article)
    }

    private val DUMMY_Articles: MutableList<Article> = mutableListOf(

    )


}