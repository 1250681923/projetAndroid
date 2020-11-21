package com.example.newsletter.fragment.pays

import android.os.Build
import android.os.Bundle
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
import com.example.newsletter.NavigationIconClickListener
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.adapters.ListArticlesAdapter
import com.example.newsletter.adapters.ListArticlesHandler
import com.example.newsletter.data.ArticleRepository
import com.example.newsletter.data.FavoritsLocal.FavoritsRepository
import com.example.newsletter.fragment.*

import com.example.newsletter.models.Article
import kotlinx.android.synthetic.main.list_articles_fragment.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavoritsFragment: Fragment(), ListArticlesHandler{

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

        // Set up the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar)
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
        setHasOptionsMenu(true)
        val articles = getListArticlesFav()
        val adapter = ListArticlesAdapter(articles,this)
        recyclerView.adapter = adapter
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
                it.changeFragment(FavoritsFragment())
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


    override fun onFavoritsArticle(article: Article) {
        FavoritsRepository.getInstance().createFavorit(article)
    }

    override fun onRemoveFavArticle(article: Article) {
        FavoritsRepository.getInstance().remove(article)
        recyclerView.adapter?.notifyDataSetChanged()
    }

    override fun getListArticlesFav(): List<Article> {
        return FavoritsRepository.getInstance().getFavorit()
    }

    override fun seeDetails(article: Article, context: View) {
        (activity as? NavigationListener)?.let {
            it.changeFragment(ArticleDetailsInforFragment(article, context))
        }
    }

}

