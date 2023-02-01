package com.example.lovecalculatormvvm

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
//import com.example.lovecalculator.databinding.FragmentCalculateBinding
//import com.example.lovecalculatormvvm.remote.LoveModel
//import com.example.lovecalculatormvvm.remote.RetrofitService
//import com.example.lovecalculator.viewmodel.LoveViewModel
import com.example.lovecalculatormvvm.databinding.FragmentCalculateBinding
import com.example.lovecalculatormvvm.viewmodel.LoveViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CalculateFragment : Fragment() {

    private lateinit var binding: FragmentCalculateBinding
    private val viewModel : LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initClickers()
    }

    private fun initClickers() {
        with(binding) {
            calculateBtn.setOnClickListener {
                viewModel.getLiveLove(firstNameEd.text.toString(),secondNameEd.text.toString()).observe(
                    viewLifecycleOwner, Observer {
                        findNavController().navigate(R.id.resultFragment, bundleOf("key" to (it?.percentage
                                )))
                    }
                )
            }
        }
    }

}