package com.live.fintnesstask.ui.main.Fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.live.fintnesstask.Home
import com.live.fintnesstask.adapter.OffersAdapter
import com.live.fintnesstask.R
import com.live.fintnesstask.util.Resource
import com.live.fintnesstask.viewmodel.FitViewmodel
import kotlinx.android.synthetic.main.fragment_offers.*

class OffersFragment :Fragment(R.layout.fragment_offers){
    lateinit var viewModel: FitViewmodel
    lateinit var offersAdapter: OffersAdapter
    val TAG="OffersFragment"
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        viewModel=(activity as Home).viewModel
        viewModel.testDatalist.observe(viewLifecycleOwner, Observer {response->
            when(response){
                is Resource.Success->{
                    hideProgresBar()
                    response.data?.let { newResponse->
                        Glide.with(this).load(newResponse.result.decription_image).into(imageView)
                        offersAdapter.differ.submitList(newResponse.result.cupons)
                    }
                }
                is Resource.Error->{
                    response.message?.let {
                        Log.e(TAG,it + "- error occurred-")
                    }
                }
                is Resource.Loading->{
                    showProgresBar()
                }
            }
        })
    }
    private fun setupRecycler() {
        offersAdapter= OffersAdapter()
        recycler.apply {
            adapter=offersAdapter
            layoutManager= LinearLayoutManager(activity)
        }
    }
    private fun showProgresBar() {
        progressBar.visibility=View.VISIBLE

    }

    private fun hideProgresBar() {
        progressBar.visibility=View.INVISIBLE
    }
}