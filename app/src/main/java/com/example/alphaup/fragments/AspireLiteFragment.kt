package com.example.alphaup.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.alphaup.R
import com.example.alphaup.activities.BuyActivity
import com.example.alphaup.databinding.ActivityBuyBinding
import com.example.alphaup.databinding.FragmentAspireliteBinding
import com.example.alphaup.databinding.FragmentWelcomingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class AspireLiteFragment : Fragment() {
    private lateinit var binding : FragmentAspireliteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_aspirelite,container,false)

            binding.floatingPriceAspireLite.setOnClickListener {
                if(binding.quantityAspireLite.text.isNotEmpty()&& binding.sizeAspireLite.text.isNotEmpty()) {
                    binding.priceAspireLite.text =
                    (binding.quantityAspireLite.text.toString()).toInt().times(2000).toString()

                    binding.imageViewAspireLiteSize.visibility=View.GONE
                    binding.addToCardAspireLite.visibility= View.VISIBLE
                    binding.phoneNumAspireLite.visibility= View.VISIBLE
                    binding.namePersonAspireLite.visibility= View.VISIBLE
            }

        }


            binding.addToCardAspireLite.setOnClickListener {
                if(binding.phoneNumAspireLite.text.isNotEmpty() && binding.namePersonAspireLite.text.isNotEmpty())
                {

                val intent = Intent(activity, BuyActivity::class.java)
                    intent.putExtra("namePersonAspireLite",binding.namePersonAspireLite.text.toString())
                    intent.putExtra("phoneNumAspireLite",binding.phoneNumAspireLite.text.toString())
                    intent.putExtra("sizeAspireLite",binding.sizeAspireLite.text.toString())
                    intent.putExtra("quantityAspireLite",binding.quantityAspireLite.text.toString())
                    intent.putExtra("priceAspireLite",binding.priceAspireLite.text.toString())
                    intent.putExtra("noOfPageAspireLite",3)
                    startActivity(intent)

            }
        }

        return binding.root
    }


}