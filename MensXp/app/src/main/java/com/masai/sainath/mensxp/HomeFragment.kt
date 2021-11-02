package com.masai.sainath.mensxp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.appcompat.app.AppCompatActivity




class HomeFragment : Fragment() {

    lateinit var toggle: ActionBarDrawerToggle


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)

    }


}


//        toggle = ActionBarDrawerToggle(requireActivity(), drawerlayout, R.string.open, R.string.close)
//        drawerlayout.addDrawerListener(toggle)
//        toggle.syncState()
//
//        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//
//        navview1.setNavigationItemSelectedListener {
//            if (it.itemId==R.id.nav_notifications) run {
//                Toast.makeText(
//                    activity,
//                    "Notification",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//                true
//        }
//        Ivmenu.setOnClickListener {
//            drawerlayout.openDrawer(navview1)
//        }
