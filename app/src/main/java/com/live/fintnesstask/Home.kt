package com.live.fintnesstask

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.viewpager.widget.ViewPager
import com.androiddevs.mvvmnewsapp.viewmodel.NewViewModelProviderFactory
import com.google.android.material.tabs.TabLayout
import com.live.fintnesstask.adapter.ViewPagerAdapter
import com.live.fintnesstask.repository.FitRepository
import com.live.fintnesstask.ui.main.Fragments.DetailsFragment
import com.live.fintnesstask.ui.main.Fragments.OffersFragment
import com.live.fintnesstask.viewmodel.FitViewmodel

class Home : AppCompatActivity() {
    lateinit var viewModel: FitViewmodel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        val tabs: TabLayout = findViewById(R.id.tabs)
        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(OffersFragment(), "Offers")
        pagerAdapter.addFragment(DetailsFragment(), "Details")
        viewPager.adapter = pagerAdapter
        tabs.setupWithViewPager(viewPager)
        tabs.setTabTextColors(Color.WHITE, resources.getColor(R.color.purple_500))
        tabs.setSelectedTabIndicatorColor(resources.getColor(R.color.purple_500))
        val fitRepository=FitRepository(this)
        val newViewModelProviderFactory=NewViewModelProviderFactory(fitRepository)
        viewModel=ViewModelProvider(this,newViewModelProviderFactory).get(FitViewmodel::class.java)
       // setupViewPager()
    }


}