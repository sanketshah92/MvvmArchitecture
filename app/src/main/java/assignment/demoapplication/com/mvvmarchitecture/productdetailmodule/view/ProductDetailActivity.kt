package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.view

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import assignment.demoapplication.com.mvvmarchitecture.DescriptionData
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.base.BaseActivity
import assignment.demoapplication.com.mvvmarchitecture.databinding.ActivityProductDetailLayoutBinding
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.adapter.*
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.Facet
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.viewmodel.ProductDetailViewModel
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiServiceID.Companion.GET_PRODUCT_DETAIL_SERVICE_ID
import kotlinx.android.synthetic.main.activity_product_detail_layout.*
import kotlinx.android.synthetic.main.activity_product_detail_layout.viewPager
import javax.inject.Inject

class ProductDetailActivity : BaseActivity() {

    private lateinit var binding : ActivityProductDetailLayoutBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val productDetailViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ProductDetailViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_detail_layout)
        init()
    }

     private fun init() {
        productDetailViewModel.getProductDetail()
        observeApiResposne()
    }

    private fun observeApiResposne() {
        productDetailViewModel.apiResponse.observe(this, Observer { response ->
            when (response.serviceID) {
                GET_PRODUCT_DETAIL_SERVICE_ID -> {
                    binding.data = response.productDetailResult
                    setUpProductImage(response.productDetailResult.skuImageUrls)
                    setUpTabs(response.productDetailResult.facets)
                    binding.rvNoNastiesImages.apply {
                        adapter = CleanBeautyImageAdapter(this@ProductDetailActivity, response.productDetailResult.cleanBeauty.imageUrls)
                        layoutManager = LinearLayoutManager(this@ProductDetailActivity, LinearLayoutManager.HORIZONTAL, false )
                    }

                    binding.comboRecyclerView.apply {
                        adapter = ComboRecyclerViewAdapter(this@ProductDetailActivity, response.productDetailResult.productCombo)
                        layoutManager = LinearLayoutManager(this@ProductDetailActivity, LinearLayoutManager.HORIZONTAL, false )
                    }

                    binding.volumeRecyclerView.apply {
                        adapter = VolumeRecyclerViewAdapter(this@ProductDetailActivity, response.productDetailResult.variants.volume)
                        layoutManager = LinearLayoutManager(this@ProductDetailActivity, LinearLayoutManager.HORIZONTAL, false )
                    }
                }
            }
        })
    }

    private fun setUpTabs(facets: List<Facet>) {
        val tabViewPagerAdapter =
            TabViewPagerAdapter(
                this@ProductDetailActivity,
                supportFragmentManager,
                facets
            )

        binding.tabViewPager.apply {
            adapter = tabViewPagerAdapter
            //offscreenPageLimit = 2
        }

        binding.tabLayout.apply {
            setupWithViewPager(tabViewPager)
        }
    }

    private fun setUpProductImage(skuImageUrls: List<String>) {
        val productImageViewPagerAdapter =
            ProductImageViewPagerAdapter(
                this@ProductDetailActivity,skuImageUrls
            )
        binding.viewPager.apply {
            adapter = productImageViewPagerAdapter
        }
        worm_dots_indicator.setViewPager(viewPager)
    }

}
