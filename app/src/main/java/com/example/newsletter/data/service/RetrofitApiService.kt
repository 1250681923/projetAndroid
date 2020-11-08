package com.example.newsletter.data.service

import com.example.newsletter.models.Article
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiService {
    //GET --> On lance une requête de type GET
    // everything est l'action du web service qu'on veut apeler
    // Elle sera concaténée avec l'url prédéfini dans retrofit
    @GET("/everything")
    fun list(): Call<List<Article>>
}