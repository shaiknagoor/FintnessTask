package com.live.fintnesstask.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.live.fintnesstask.ui.main.Fragments.DetailsFragment
import com.live.fintnesstask.ui.main.Fragments.OffersFragment
import java.util.*

class ViewPagerAdapter(val manager: FragmentManager?) : FragmentPagerAdapter(manager!!) {
    private val mFragmentList: MutableList<Fragment> = ArrayList<Fragment>()
    private val mFragmentTitleList: MutableList<String> = ArrayList()

    override fun getCount(): Int {
        return mFragmentList.size
    }

    fun addFragment(fragment: Fragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mFragmentTitleList[position]
    }

    override fun getItem(position: Int): Fragment {
      //  TODO("Not yet implemented")
        when (position) {
            0 -> {
                val bundle = Bundle()
                val offersFragment = OffersFragment()
              /*  bundle.putSerializable("loginDetails", loginDetails as Serializable?)
                dropOutFragment.setArguments(bundle)*/
                return offersFragment
            }
            1 -> {
                val bundle1 = Bundle()
                val detailsFragment = DetailsFragment()
              /*  bundle1.putSerializable("loginDetails", loginDetails as Serializable?)
                neverEnrollFragment.setArguments(bundle1)*/
                return detailsFragment
            }
        }
        throw IllegalStateException("position $position is invalid for this viewpager")
    }
}