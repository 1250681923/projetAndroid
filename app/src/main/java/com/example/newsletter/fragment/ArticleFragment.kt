package com.example.newsletter.fragment

import android.os.Build
import android.os.Bundle
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.MainActivity
import com.example.newsletter.NavigationIconClickListener
import com.example.newsletter.R
import com.example.newsletter.adapters.ListArticlesAdapter
import com.example.newsletter.adapters.ListArticlesHandler
import com.example.newsletter.data.ArticleRepository
import com.example.newsletter.models.Article
import kotlinx.android.synthetic.main.list_articles_fragment.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ArticleFragment: Fragment(), ListArticlesHandler{

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

        (activity as AppCompatActivity).setSupportActionBar( view.app_bar)
//        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(activity!!, view.product_grid))
       // view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(activity!!, view.product_grid, AccelerateDecelerateInterpolator()))
       // (activity as AppCompatActivity).setSupportActionBar(view.findViewById(R.id.app_bar))
        recyclerView = view.findViewById(R.id.articles_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        )
        // Set cut corner background for API 23+
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//            view.product_grid.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
//        }

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        getArticles()

    }


    /**
     * Récupère la liste des articles dans un thread secondaire
     */
    private fun getArticles(){
        lifecycleScope.launch(Dispatchers.IO) {
            val articles = ArticleRepository.getInstance().getArticles("bitcoin")
            bindData(articles.articles)
        }
    }

    /**
     * Rempli le recyclerview avec les données récupérées dans le web service
     * Cette action doit s'effectuer sur le thread principale
     * Car on ne peut mas modifier les éléments de vue dans un thread secondaire
     */
    private fun bindData(articles: List<Article>){
        val adapter = ListArticlesAdapter(articles, this)
        lifecycleScope.launch(Dispatchers.Main) {

            recyclerView.adapter = adapter
        }
    }

    override fun onFavoritsArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun onRemoveFavArticle(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getListArticlesFav(): List<Article> {
        TODO("Not yet implemented")
    }

    override fun seeDetails(article: Article, context: View) {
        TODO("Not yet implemented")
    }

}

