package com.example.newsletter

import android.app.Application
import com.example.newsletter.data.ArticleRepository
import kotlin.properties.Delegates

class MyApplication: Application() {

//    companion object {
//
//        var instance: MyApplication by Delegates.notNull()
//
//        fun instance() = instance
//    }
//
//    override fun onCreate() {
//        super.onCreate()
//
//        instance = this
//    }
    companion object {
        //private var instance: MyApplication? = null
        var instance: MyApplication by Delegates.notNull()
        fun Instance(): MyApplication {
            if (instance == null) {
                instance = MyApplication()
            }
            return instance!!
        }
    }
}