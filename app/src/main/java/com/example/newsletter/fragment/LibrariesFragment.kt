package com.example.newsletter.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsletter.R
import com.example.newsletter.adapters.ListLibrariesAdapter
import com.example.newsletter.data.LibrariesRepository

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
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = LibrariesRepository.getInstance().getNeighbours()
        val adapter = ListLibrariesAdapter(neighbors)
        recyclerView.adapter = adapter
    }
}