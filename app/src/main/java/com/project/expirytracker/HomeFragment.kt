package com.project.expirytracker

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val addItem = requireView().findViewById<FloatingActionButton>(R.id.add_item)
        addItem.setOnClickListener{
            val transition = activity?.supportFragmentManager?.beginTransaction()
            if (transition != null) {
                transition.replace(R.id.nav_host_fragment,AddItemFragment.newInstance())
                transition.addToBackStack(null)
                transition.commit()
            }
        }

        val listItem = listOf<ItemModel>(
            ItemModel("Tropicana",40,2024,2,11),
            ItemModel("Cake",40,2024,12,11),
            ItemModel("GoodDay",40,2024,2,11)
        )

        val adapter = ItemAdapter(listItem)
        val recyle = requireView().findViewById<RecyclerView>(R.id.item_view)
        recyle.layoutManager = LinearLayoutManager(requireContext())
        recyle.adapter = adapter
    }
    companion object {
        fun newInstance() = HomeFragment()
    }
}