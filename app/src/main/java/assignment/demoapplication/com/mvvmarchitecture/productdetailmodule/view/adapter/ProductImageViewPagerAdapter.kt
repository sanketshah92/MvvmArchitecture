package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.view.adapter

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.ViewpagerImageLayoutBinding
import com.bumptech.glide.Glide


class ProductImageViewPagerAdapter(
    val context: Context,
    val skuImageUrls: List<String>
) : PagerAdapter() {

    lateinit var layoutInflater: LayoutInflater
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return skuImageUrls.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        //super.destroyItem(container, position, `object`)
        (container as ViewPager).removeView(`object` as View)

    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val binding : ViewpagerImageLayoutBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.viewpager_image_layout, null, false)

        (container as ViewPager).addView(binding.root, 0)
        binding.imageUrl = skuImageUrls[position]
        return binding.root
    }

    companion object {

        @JvmStatic
        @BindingAdapter("imageUrls")
        fun loadImage(view: ImageView, url: String) {
            Glide.with(view.context).load(url).into(view)
        }
    }
}