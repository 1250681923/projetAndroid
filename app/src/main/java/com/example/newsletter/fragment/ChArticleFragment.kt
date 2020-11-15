package com.example.newsletter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.adapters.ListArticlesAdapter
import com.example.newsletter.adapters.ListArticlesHandler
import com.example.newsletter.data.ArticleRepository
import com.example.newsletter.models.Article
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChArticleFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView

    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_articles_fragment, container, false)
        recyclerView = view.findViewById(R.id.articles_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        )
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticles()

    }


    /**
     * Récupère la liste des articles dans un thread secondaire
     */
    private fun getArticles(){
        lifecycleScope.launch(Dispatchers.IO) {
            val articles = ArticleRepository.getInstance().getArticlesByCountry("cn")
            bindData(articles.articles)
        }
    }

    /**
     * Rempli le recyclerview avec les données récupérées dans le web service
     * Cette action doit s'effectuer sur le thread principale
     * Car on ne peut mas modifier les éléments de vue dans un thread secondaire
     */
    private fun bindData(articles: List<Article>){
        val adapter = ListArticlesAdapter(articles)
        lifecycleScope.launch(Dispatchers.Main) {

            recyclerView.adapter = adapter
        }
    }

}

