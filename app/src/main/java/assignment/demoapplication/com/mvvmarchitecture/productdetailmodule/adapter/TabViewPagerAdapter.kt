package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import assignment.demoapplication.com.mvvmarchitecture.DescriptionData
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.Facet
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.view.TabFragment

class TabViewPagerAdapter(
    var context: Context?,
    childFragmentManager: FragmentManager,
    var titles: List<Facet>
) : FragmentPagerAdapter(childFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {


    override fun getCount(): Int {
        return titles.size
    }

    override fun getItem(position: Int): Fragment {
        var content = ""
        titles[position].content.let {
            content = it
        }
        return TabFragment(
            content
        )
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return titles[position].title
    }
}