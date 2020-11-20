package com.example.newsletter.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.NavigationListener
import com.example.newsletter.R
import com.example.newsletter.adapters.ListLibrariesAdapter
import com.example.newsletter.data.LibrariesRepository
import com.example.newsletter.fragment.pays.FavoritsFragment
import kotlinx.android.synthetic.main.developpeur.view.*
import kotlinx.android.synthetic.main.libraries.*
import kotlinx.android.synthetic.main.libraries.view.*

class LibrariesFragment: Fragment() {
    private lateinit var recyclerView: RecyclerView
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.libraries, container, false)
        recyclerView = view.findViewById(R.id.libraries_list)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        // Set up the toolbar.
        (activity as AppCompatActivity).setSupportActionBar(view.app_bar3)
        return view
        /*        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        changeFragment(ListNeighborsFragment())*/

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
        val libraries = LibrariesRepository.getInstance().getlibraries()
        val adapter = ListLibrariesAdapter(libraries)
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
                it.changeFragment(PageAccueilFragment())
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}