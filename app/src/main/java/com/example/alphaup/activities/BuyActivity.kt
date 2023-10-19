package com.example.alphaup.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.VIEW_MODEL_STORE_OWNER_KEY
import com.example.alphaup.R
import com.example.alphaup.databinding.ActivityBuyBinding
import com.example.alphaup.databinding.ActivityMainBinding
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint

private lateinit var binding : ActivityBuyBinding
@AndroidEntryPoint
class BuyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_buy)

        //for active
        val noOfPageActive = intent.extras?.getInt("noOfPageActive")
        val namePersonActive = intent.extras?.getString("namePersonActive","")
        val phoneNumActive = intent.extras?.getString("phoneNumActive","")
        val sizeActive =  intent.extras?.getString("sizeActive","")
        val quantityActive = intent.extras?.getString("quantityActive","")
        val priceActive =  intent.extras?.getString("priceActive","")

        //for aspire
        val noOfPageAspire = intent.extras?.getInt("noOfPageAspire")
        val namePersonAspire = intent.extras?.getString("namePersonAspire"," ")
        val phoneNumAspire = intent.extras?.getString("phoneNumAspire"," ")
        val sizeAspire = intent.extras?.getString("sizeAspire"," ")
        val quantityAspire = intent.extras?.getString("quantityAspire"," ")
        val priceAspire = intent.extras?.getString("priceAspire"," ")

        //for aspireLite
        val noOfPageAspireLite = intent.extras?.getInt("noOfPageAspireLite")
        val namePersonAspireLite = intent.extras?.getString("namePersonAspireLite","  ")
        val phoneNumAspireLite = intent.extras?.getString("phoneNumAspireLite","  ")
        val sizeAspireLite =  intent.extras?.getString("sizeAspireLite","  ")
        val quantityAspireLite = intent.extras?.getString("quantityAspireLite","  ")
        val priceAspireLite =  intent.extras?.getString("priceAspireLite","  ")

        var name = ""
        var phone = ""
        var size =""
        var quantity =""
        var price =""

        if(noOfPageActive == 1)
        {
             name = namePersonActive.toString()
             phone = phoneNumActive.toString()
             size =sizeActive.toString()
             quantity =quantityActive.toString()
             price =priceActive.toString()
        }

        if(noOfPageAspireLite== 3)
        {
             name = namePersonAspireLite.toString()
             phone = phoneNumAspireLite.toString()
             size =sizeAspireLite.toString()
             quantity =quantityAspireLite.toString()
             price =priceAspireLite.toString()
        }

        if(noOfPageAspire ==2)
        {
             name = namePersonAspire.toString()
             phone = phoneNumAspire.toString()
             size =sizeAspire.toString()
             quantity =quantityAspire.toString()
             price =priceAspire.toString()
        }

            binding.namePersonBuy.text=name.toString()
            binding.phoneNumberPersonBuy.text=phone.toString()
            binding.sizeBuy.text=size.toString()
            binding.quantityBuy.text=quantity.toString()
            binding.priceBuy.text=price.toString()


          /*binding.namePersonBuy.text=namePersonAspire.toString()
            binding.phoneNumberPersonBuy.text=phoneNumAspire.toString()
            binding.sizeBuy.text=sizeAspire.toString()
            binding.quantityBuy.text=quantityAspire.toString()
            binding.priceBuy.text=priceAspire.toString()


            binding.namePersonBuy.text=namePersonAspireLite.toString()
            binding.phoneNumberPersonBuy.text=phoneNumAspireLite.toString()
            binding.sizeBuy.text=sizeAspireLite.toString()
            binding.quantityBuy.text=quantityAspireLite.toString()
            binding.priceBuy.text=priceAspireLite.toString()*/

    }

    override fun onResume() {
        super.onResume()
        //To Add ToolBar(in ActionBar) for all fragments with appBarConfiguration
        setSupportActionBar(binding.toolbarBuy)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(com.example.alphaup.R.menu.menu3, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.signOut ->{
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                Firebase.auth.signOut()
            }
            R.id.products ->{
                val intent = Intent(this, ProductsActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }
}