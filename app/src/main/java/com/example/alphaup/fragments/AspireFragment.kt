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
import com.example.alphaup.databinding.FragmentAspireBinding
import com.example.alphaup.databinding.FragmentWelcomingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class AspireFragment : Fragment() {
    private lateinit var binding: FragmentAspireBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_aspire, container, false)

        binding.floatingPriceAspire.setOnClickListener {
            if (binding.quantityAspire.text.isNotEmpty() && binding.sizeAspire.text.isNotEmpty()) {
                binding.priceAspire.text =
                    (binding.quantityAspire.text.toString()).toInt().times(3000).toString()
                binding.imageViewAspireSize.visibility = View.GONE
                binding.addToCardAspire.visibility = View.VISIBLE
                binding.phoneNumAspire.visibility = View.VISIBLE
                binding.namePersonAspire.visibility = View.VISIBLE
            }

        }


        binding.addToCardAspire.setOnClickListener {

            if (binding.phoneNumAspire.text.isNotEmpty() && binding.namePersonAspire.text.isNotEmpty()) {

                val intent = Intent(activity, BuyActivity::class.java)
                intent.putExtra("namePersonAspire", binding.namePersonAspire.text.toString())
                intent.putExtra("phoneNumAspire", binding.phoneNumAspire.text.toString())
                intent.putExtra("sizeAspire", binding.sizeAspire.text.toString())
                intent.putExtra("quantityAspire", binding.quantityAspire.text.toString())
                intent.putExtra("priceAspire", binding.priceAspire.text.toString())
                intent.putExtra("noOfPageAspire",2)
                startActivity(intent)

            }
        }

        return binding.root
    }

}