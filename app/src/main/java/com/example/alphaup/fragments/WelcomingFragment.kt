package com.example.alphaup.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.alphaup.R
import com.example.alphaup.databinding.FragmentWelcomingBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
@AndroidEntryPoint
class WelcomingFragment : Fragment() {

private lateinit var binding : FragmentWelcomingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(inflater,R.layout.fragment_welcoming,container,false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            binding.goBtnWelcome.visibility=View.VISIBLE

        binding.goBtnWelcome.setOnClickListener {
            binding.apply {
                startingImageView.visibility=View.GONE
                goBtnWelcome.visibility=View.GONE
                aboutusconstraintlayout.visibility=View.VISIBLE
                skipBtn.visibility=View.VISIBLE
            }
        }

        binding.nextBtnAboutUs.setOnClickListener {
            binding.apply {
                aboutusconstraintlayout.visibility=View.GONE
                objectiveslayout.visibility=View.VISIBLE
            }
        }

        binding.nextBtnobjectives.setOnClickListener {
            binding.apply {
                objectiveslayout.visibility=View.GONE
                whySportslayout.visibility=View.VISIBLE
            }
        }

        binding.backBtnobjectives.setOnClickListener {
            binding.apply {
                objectiveslayout.visibility=View.GONE
                aboutusconstraintlayout.visibility=View.VISIBLE
            }
        }

        binding.nextBtnwhySports.setOnClickListener {
            binding.apply {
                whySportslayout.visibility=View.GONE
                electromyalicstimulationlayout.visibility=View.VISIBLE
                skipBtn.visibility=View.GONE
            }
        }

        binding.backBtnwhySports.setOnClickListener {
            binding.apply {
                whySportslayout.visibility=View.GONE
                objectiveslayout.visibility=View.VISIBLE
            }
        }


        binding.nextBtnelectromyalicstimulation.setOnClickListener {
            binding.apply {
                findNavController().navigate(R.id.action_welcomingFragment_to_signInAndSignUpFragment)
            }
        }

        binding.backBtnelectromyalicstimulation.setOnClickListener {
            binding.apply {
                electromyalicstimulationlayout.visibility=View.GONE
                whySportslayout.visibility=View.VISIBLE
                skipBtn.visibility=View.VISIBLE
            }
        }

        binding.skipBtn.setOnClickListener {
            binding.apply {
                findNavController().navigate(R.id.action_welcomingFragment_to_signInAndSignUpFragment)
            }
        }

    }
}