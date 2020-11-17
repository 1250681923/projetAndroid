package com.example.newsletter.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.newsletter.data.service.FavoritsApiService
import com.example.newsletter.fragment.FrArticleFragment
import com.example.newsletter.models.Article

@Database(entities = arrayOf(Article::class), version = 1)
abstract class FavoritsDatabase : RoomDatabase() {

    abstract fun FavoritsApiService(): FavoritsApiService

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


//    companion object {
//
//        @Volatile
//        private var instance: FavoritsDatabase? = null
//
//        fun getInstance(): FavoritsDatabase {
//
//            if (instance == null) {
//
//                synchronized(FavoritsDatabase::class) {
//
//                    if (instance == null) {
//
//                        instance = Room.databaseBuilder(
//                            MyApplication.instance(),
//                            FavoritsDatabase::class.java,
//                            "Article.db"
//                        )
//                            .allowMainThreadQueries()
//                            .build()
//                    }
//                }
//            }
//            return instance!!
//        }
//
//    }
}