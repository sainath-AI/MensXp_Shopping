package com.masai.sainath.mensxp.ui.activity

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.masai.sainath.mensxp.R
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("RtlHardcoded")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Cart.setOnClickListener {
            intent = Intent(this,CartActivity::class.java)
            startActivity(intent)
            finish()

        }
        Wishlist.setOnClickListener {
            intent = Intent(this,WishListActivity::class.java)
            startActivity(intent)
            finish()
        }


        val navController = findNavController(R.id.fragmentContainerView)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.BottomNavView)
        bottomNavigationView.setupWithNavController(navController)


        toggle = ActionBarDrawerToggle(this, drawerlayout, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

      Ivmenu.setOnClickListener {
          if (drawerlayout.isDrawerOpen(Gravity.LEFT)){
              drawerlayout.closeDrawer(Gravity.LEFT)
          }else
          {
              drawerlayout.openDrawer(Gravity.LEFT)
          }
      }

        navview1.setNavigationItemSelectedListener {


            when(it.itemId){
                R.id.nav_notifications ->{
                    intent= Intent(this, NotificationActivity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_orders ->{
                    intent= Intent(this, OrdersActivity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_cart ->{
                    intent= Intent(this, CartActivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.nav_wishList ->{
                    intent= Intent(this, WishListActivity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_editprofile ->{
                    intent= Intent(this, EditProfileAcitivity::class.java)
                    startActivity(intent)

                    true
                }

                R.id.nav_bookmarks ->{
                    intent= Intent(this, OrdersActivity::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_address ->{
                    intent= Intent(this, MyAddress::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_Terms ->{
                    intent= Intent(this, TermsAndCoditions::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_policy ->{
                    intent= Intent(this, PrivacyPolicy::class.java)
                    startActivity(intent)

                    true
                }
                R.id.nav_loveApp ->{
                    val uri = Uri.parse("market://details?id=$packageName")
                    val myAppLinkToMarket = Intent(Intent.ACTION_VIEW, uri)
                    try {
                        startActivity(myAppLinkToMarket)
                    } catch (e: ActivityNotFoundException) {
                        Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show()
                    }

                    true
                }
                R.id.nav_inviteFrnds ->{
                    try {
                        val shareIntent = Intent(Intent.ACTION_SEND)
                        shareIntent.type = "text/plain"
                        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name")
                        var shareMessage = "\nInstall this application for poetry\n\n"
                        shareMessage =
                            """
                            ${shareMessage}https://play.google.com/store/apps/details?id=$packageName


                            """.trimIndent()
                        shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
                        startActivity(Intent.createChooser(shareIntent, "choose one"))
                    } catch (e: Exception) {
                        //e.toString();
                    }

                    true
                }
                R.id.nav_logout ->{


                    true
                }


                else->{
                    false
                }
            }




        }





    }


    override fun onBackPressed() {
        if (drawerlayout.isDrawerOpen(Gravity.LEFT)){
            drawerlayout.closeDrawer(Gravity.LEFT)
        }else
        {
            super.onBackPressed()

        }
    }


}
