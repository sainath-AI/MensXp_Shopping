package com.masai.sainath.mensxp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sainath.mensxp.R
import com.masai.sainath.mensxp.adapters.AddressAdapter
import com.masai.sainath.mensxp.adapters.OnRowItemClicked
import com.masai.sainath.mensxp.roomdata.AddressDao
import com.masai.sainath.mensxp.roomdata.AddressEntity
import com.masai.sainath.mensxp.roomdata.Roomdb
import kotlinx.android.synthetic.main.activity_my_address.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Observer

class MyAddress : AppCompatActivity() ,OnRowItemClicked{

    val listOfAddress = mutableListOf<AddressEntity>()
    lateinit var adapter: AddressAdapter

    lateinit var roomDb : Roomdb
    lateinit var addressDao: AddressDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_address)



        AddAdress.setOnClickListener {
            intent = Intent(this, EditAddress::class.java)
            startActivity(intent)
        }

        roomDb = Roomdb.getDatabase(this)
        addressDao= roomDb.getMoneyDao()

        adapter = AddressAdapter(listOfAddress, this)
        RevAddress.layoutManager = LinearLayoutManager(this)
        RevAddress.adapter=adapter

        addressDao.getMoney().observe(this, androidx.lifecycle.Observer {
            val data = it

            listOfAddress.clear()
            listOfAddress.addAll(data)
            adapter.notifyDataSetChanged()

        })


    }

    override fun onEditButtonClicked(addressEntity: AddressEntity) {

        var intents = Intent(this,EditAddress::class.java)
        Toast.makeText(this,"Long Press to Edit Title,Type,Amount", Toast.LENGTH_LONG).show()
        startActivity(intents)
        var bundle = intent.extras

        var editName = bundle?.getString("name")
        var editAddress1 = bundle?.getString("add1")
        var editAddress2 = bundle?.getInt("add2")
        var editAddress3 = bundle?.getString("add3")
        var editAddress4 = bundle?.getInt("add4")
        var editEmail = bundle?.getString("email")
        var editMobile = bundle?.getString("mobile")


        addressEntity.name = editName.toString()
        addressEntity.address1 = editAddress1.toString()
        addressEntity.address2 = editAddress2.toString()
        addressEntity.address3 = editAddress3.toString()
        addressEntity.address4 = editAddress4.toString()
        addressEntity.email = editEmail.toString()
        addressEntity.mobile = editMobile.toString()


        CoroutineScope(Dispatchers.IO).launch{
            addressDao.Update(addressEntity)
        }
    }

    override fun onDeleteButtonClicked(addressEntity: AddressEntity) {

        CoroutineScope(Dispatchers.IO).launch{
            addressDao.Delete(addressEntity)
        }
    }
}