package com.example.newsletter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.newsletter.adapters.ListArticlesHandler
import com.example.newsletter.fragment.ArticleFragment
import com.example.newsletter.fragment.PageAccueilFragment
import com.example.newsletter.models.Article

class MainActivity : AppCompatActivity(), NavigationListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        changeFragment(PageAccueilFragment())
    }


    override fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragment_container, fragment)
            addToBackStack(null)
        }.commit()
    }



}