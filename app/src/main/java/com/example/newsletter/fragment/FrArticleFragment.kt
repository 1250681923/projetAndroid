package com.example.newsletter.fragment

import android.os.Build
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.MainActivity
import com.example.newsletter.NavigationIconClickListener
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.adapters.ListArticlesAdapter
import com.example.newsletter.adapters.ListArticlesHandler
import com.example.newsletter.data.ArticleRepository
import com.example.newsletter.models.Article
import kotlinx.android.synthetic.main.list_articles_fragment.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FrArticleFragment : Fragment(){

    private lateinit var recyclerView: RecyclerView
    private lateinit var politics: Button
    private lateinit var business: Button
    private lateinit var entertainment: Button
    private lateinit var general: Button
    private lateinit var health: Button
    private lateinit var science: Button
    /**
     * Fonction permettant de définir une vue à attacher à un fragment
     */
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.list_articles_fragment, container, false)

        politics = view.findViewById(R.id.politics)
        business = view.findViewById(R.id.business)
        entertainment = view.findViewById(R.id.entertainment)
        general =view.findViewById(R.id.general)
        health = view.findViewById(R.id.health)
        science = view.findViewById(R.id.science)

        // Set up the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
        view.app_bar.setNavigationOnClickListener(NavigationIconClickListener(
            activity!!,
            view.articles_list,
            AccelerateDecelerateInterpolator(),
            ContextCompat.getDrawable(context!!, R.drawable.shr_branded_menu), // Menu open icon
            ContextCompat.getDrawable(context!!, R.drawable.shr_close_menu))) // Menu close icon

        recyclerView = view.findViewById(R.id.articles_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
                DividerItemDecoration(
                        requireContext(),
                        DividerItemDecoration.VERTICAL
                )
        )
        // Set cut corner background for API 23+
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            view.articles_list.background = context?.getDrawable(R.drawable.shr_product_grid_background_shape)
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArticles()
        setHasOptionsMenu(true)

        politics.setOnClickListener {
            getArticlesByCategory("politics")
        }
        business.setOnClickListener {
            getArticlesByCategory("business")
        }
        entertainment.setOnClickListener {
            getArticlesByCategory("entertainment")
        }
        general.setOnClickListener {
            getArticlesByCategory("general")
        }
        health.setOnClickListener {
            getArticlesByCategory("health")
        }
        science.setOnClickListener {
            getArticlesByCategory("science")
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, menuInflater: MenuInflater) {
        menuInflater.inflate(R.menu.shr_toolbar_menu, menu)
        super.onCreateOptionsMenu(menu, menuInflater)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.page_1) {
            (activity as? NavigationListener)?.let {
                it.changeFragment(PageAccueilFragment())
            }
            return true
        }

        if (id == R.id.page_2) {
            (activity as? NavigationListener)?.let {
                it.changeFragment(PageAccueilFragment())
            }
            return true
        }

        //developpeur
        if (id == R.id.page_3) {
            (activity as? NavigationListener)?.let {
                it.changeFragment(DeveloppeurFragment())
            }
            return true
        }
        //Fonction
        if (id == R.id.page_4) {
            (activity as? NavigationListener)?.let {
                it.changeFragment(FunctionFragment())
            }
            return true
        }
        //library
        if (id == R.id.page_5) {
            (activity as? NavigationListener)?.let {
                it.changeFragment(LibrariesFragment())
            }
            return true
        }







        return super.onOptionsItemSelected(item)
    }
    /**
     * Récupère la liste des articles dans un thread secondaire
     */
    private fun getArticles(){
        lifecycleScope.launch(Dispatchers.IO) {
            val articles = ArticleRepository.getInstance().getArticlesByCountry("fr")
            bindData(articles.articles)
        }
    }

    private fun getArticlesByCategory(category:String){
        lifecycleScope.launch(Dispatchers.IO) {
            val articles = ArticleRepository.getInstance().getArticlesByCategory("fr",category)
            bindData(articles.articles)
        }
    }
    /**
     * Rempli le recyclerview avec les données récupérées dans le web service
     * Cette action doit s'effectuer sur le thread principale
     * Car on ne peut mas modifier les éléments de vue dans un thread secondaire
     */
    private fun bindData(articles: List<Article>){
        lifecycleScope.launch(Dispatchers.Main) {
            val adapter = ListArticlesAdapter(articles)
            recyclerView.adapter = adapter
        }
    }


}

