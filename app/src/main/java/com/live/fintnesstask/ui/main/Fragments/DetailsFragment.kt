package com.live.fintnesstask.ui.main.Fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.live.fintnesstask.Home
import com.live.fintnesstask.R
import com.live.fintnesstask.viewmodel.FitViewmodel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment:Fragment(R.layout.fragment_details) {
    val TAG="DetailsFragment"
    lateinit var viewModel: FitViewmodel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=(activity as Home).viewModel
        viewModel.testDatalist.observe(viewLifecycleOwner, Observer {
            it.data?.result?.let {
                descr_detail.text=it.description_body
                Glide.with(this).load(it.decription_image).into(detail_Image)
            }
        })

    }

}