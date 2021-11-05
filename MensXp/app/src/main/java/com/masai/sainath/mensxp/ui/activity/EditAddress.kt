package com.masai.sainath.mensxp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.roomdata.AddressDao
import com.masai.sainath.mensxp.roomdata.AddressEntity
import com.masai.sainath.mensxp.roomdata.Roomdb
import kotlinx.android.synthetic.main.activity_edit_address.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditAddress : AppCompatActivity() {

    lateinit var roomDb : Roomdb
    lateinit var addressDao: AddressDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_address)


        roomDb = Roomdb.getDatabase(this)
        addressDao= roomDb.getMoneyDao()


        save.setOnClickListener {

            val name = Etname.text.toString()
            val address1 = etaddess.text.toString()
            val address2 = etStreet.text.toString()
            val address3 = etPincode.text.toString()
            val address4 = etCity.text.toString()
            val email = etEmail.text.toString()
            val mobile = etMobile.text.toString()


            val addressEntity = AddressEntity(name, address1,address2,address3,address4,email,mobile )

            CoroutineScope(Dispatchers.IO).launch {
                addressDao.saveMoney(addressEntity)
            }

            if (isCredentialsValid()) {
                var intent = Intent(this, MyAddress::class.java)
                startActivity(intent)
                finish()
            }

        }

//        etTitle.setOnLongClickListener {
//            etEdit.visibility = View.VISIBLE
//            true
//        }
//
//        etType.setOnLongClickListener {
//            etEditType.visibility = View.VISIBLE
//            true
//        }
//
//        etAmount.setOnLongClickListener {
//            etEditAmount.visibility = View.VISIBLE
//            true
//        }

//        save.setOnLongClickListener {
//
//            var intent   = Intent(this, MyAddress::class.java)
//
//            intent.putExtra("title",etEdit.text.toString())
//            intent.putExtra("type",etEditType.text.toString())
//            intent.putExtra("amount",Integer.parseInt(etEditAmount.text.toString()))
//            startActivity(intent)
//            true
//        }


    }

    private fun isCredentialsValid(): Boolean {
        var isDataValid = true
        if (Etname.text.toString().isEmpty()) {

            isDataValid = false
        }

        if (etaddess.text.toString().isEmpty()) {

            isDataValid = false

        }

        if (etStreet.text.toString().isEmpty() ) {
            isDataValid = false
        }
        if (etPincode.text.toString().isEmpty()) {

            isDataValid = false
        }

        if (etCity.text.toString().isEmpty()) {

            isDataValid = false

        }

        if (etEmail.text.toString().isEmpty()) {
            isDataValid = false
        }
        if (etMobile.text.toString().isEmpty()) {
            isDataValid = false
        }
        return isDataValid
    }

}