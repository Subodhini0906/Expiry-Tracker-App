package com.project.expirytracker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class StartFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    @SuppressLint("CommitTransaction")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val getStart = requireView().findViewById<Button>(R.id.get_start)
        getStart.setOnClickListener{
            val transition = activity?.supportFragmentManager?.beginTransaction()
            if (transition != null) {
                transition.replace(R.id.nav_host_fragment,HomeFragment.newInstance())
                transition.addToBackStack(null)
                transition.commit()
            }
        }
    }
}