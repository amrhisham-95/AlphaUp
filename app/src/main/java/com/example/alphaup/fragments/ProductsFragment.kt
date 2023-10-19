package com.example.alphaup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.alphaup.R
import com.example.alphaup.databinding.FragmentProductsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint

class ProductsFragment : Fragment() {

    private lateinit var binding : FragmentProductsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= DataBindingUtil.inflate(inflater,R.layout.fragment_products,container,false)


        binding.apply {
            activeBtn.setOnClickListener {
                findNavController().navigate(R.id.action_productsFragment_to_activeFragment)
            }

            aspireBtn.setOnClickListener {
                findNavController().navigate(R.id.action_productsFragment_to_aspireFragment)
            }

            aspireLiteBtn.setOnClickListener {
                findNavController().navigate(R.id.action_productsFragment_to_aspireLiteFragment)
            }

        }
        return binding.root    }


}