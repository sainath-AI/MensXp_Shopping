package com.masai.sainath.mensxp.ui.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.databinding.FragmentHomeBinding
import com.masai.sainath.mensxp.databinding.FragmentYouBinding
import com.masai.sainath.mensxp.ui.activity.*
import kotlinx.android.synthetic.main.activity_edit_profile_acitivity.*
import kotlinx.android.synthetic.main.fragment_you.*
import java.lang.Exception


class YouFragment : Fragment() {

    lateinit var binding: FragmentYouBinding

    lateinit var mAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentYouBinding.inflate(layoutInflater, container, false)

        mAuth = FirebaseAuth.getInstance()

        binding.linear1.setOnClickListener {
          val  intent = Intent(activity,NotificationActivity::class.java)
           startActivity(intent)
        }

        binding.linear2.setOnClickListener {
          val  intent = Intent(activity,OrdersActivity::class.java)
           startActivity(intent)
        }
        binding.linear3.setOnClickListener {
          val  intent = Intent(activity,CartActivity::class.java)
           startActivity(intent)
        }
        binding.linear4.setOnClickListener {
          val  intent = Intent(activity,WishListActivity::class.java)
           startActivity(intent)
        }
        binding.layout.setOnClickListener {
          val  intent = Intent(activity,EditProfileAcitivity::class.java)
           startActivity(intent)
        }
        binding.layout1.setOnClickListener {
          val  intent = Intent(activity,MyAddress::class.java)
           startActivity(intent)
        }
        binding.layout2.setOnClickListener {
          val  intent = Intent(activity,TermsAndCoditions::class.java)
           startActivity(intent)
        }
        binding.layout3.setOnClickListener {
          val  intent = Intent(activity,PrivacyPolicy::class.java)
           startActivity(intent)
        }
        binding.layout4.setOnClickListener {
            val uri = Uri.parse("market://details?id=${activity?.packageName}")
            val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
            try {
                startActivity(myAppLinkToMarket)
            } catch (e: ActivityNotFoundException) {
                Toast.makeText(activity, " unable to find market app", Toast.LENGTH_LONG).show()
            }
        }
        binding.layout5.setOnClickListener {
            try {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.type = "text/plain"
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                var shareMessage = "\nInstall this application for poetry\n\n"
                shareMessage =
                    """
                            ${shareMessage}https://play.google.com/store/apps/details?id=${activity?.packageName}


                            """.trimIndent()
                shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                startActivity(Intent.createChooser(shareIntent, "choose one"))
            } catch (e: Exception) {
                //e.toString();
            }
        }
        binding.layout6.setOnClickListener {

            mAuth.signOut()
            val intent= Intent(activity,LoginActivity1::class.java)
             intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)

        }
//        val bundle=arguments
//        val message = bundle?.getString("firstname")
//        val message1 = bundle?.getString("lastname")
//        val message2 = bundle?.getString("phoneNumber")

     //   Tctname.text = message.toString()
       // tctlastname.text=message1.toString()
       // phone.text=message2.toString()




        return binding.root
    }


}