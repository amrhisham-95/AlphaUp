package com.example.alphaup.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.alphaup.R
import com.example.alphaup.activities.BuyActivity
import com.example.alphaup.databinding.FragmentActiveBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class ActiveFragment : Fragment() {
    private lateinit var binding : FragmentActiveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_active,container,false)


            binding.floatingPrice.setOnClickListener {
                if(binding.quantityActive.text.isNotEmpty() && binding.sizeActive.text.isNotEmpty()){
                binding.priceActive.text = (binding.quantityActive.text.toString()).toInt().times(5000).toString()
                    binding.imageViewActiveSize.visibility=View.GONE
                    binding.addToCardActive.visibility= View.VISIBLE
                    binding.phoneNumActive.visibility= View.VISIBLE
                    binding.namePersonActive.visibility= View.VISIBLE
                }

        }


            binding.addToCardActive.setOnClickListener {

                if(binding.phoneNumActive.text.isNotEmpty() && binding.namePersonActive.text.isNotEmpty())
                {
                val intent = Intent(activity,BuyActivity::class.java)
                    intent.putExtra("namePersonActive",binding.namePersonActive.text.toString())
                    intent.putExtra("phoneNumActive",binding.phoneNumActive.text.toString())
                    intent.putExtra("sizeActive",binding.sizeActive.text.toString())
                    intent.putExtra("quantityActive",binding.quantityActive.text.toString())
                    intent.putExtra("priceActive",binding.priceActive.text.toString())
                    intent.putExtra("noOfPageActive",1)
                    startActivity(intent)
            } }

        return binding.root
    }

}