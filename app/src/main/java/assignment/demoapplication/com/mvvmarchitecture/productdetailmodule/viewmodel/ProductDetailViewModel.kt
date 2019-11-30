package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import assignment.demoapplication.com.mvvmarchitecture.base.BaseViewModel
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.ApiResposne
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.ProductDetailResult
import assignment.demoapplication.com.mvvmarchitecture.repository.ProductDetailRepository
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiServiceID.Companion.GET_PRODUCT_DETAIL_SERVICE_ID
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(private val repository: ProductDetailRepository) :
    BaseViewModel(repository) {

    val apiResponse = MutableLiveData<ApiResposne>()

    fun getProductDetail() {
        repository.getProductDetail(GET_PRODUCT_DETAIL_SERVICE_ID)
    }

    override fun onSuccess(data: Any?, serviceId: Int) {
        when (serviceId) {
            GET_PRODUCT_DETAIL_SERVICE_ID -> {
                Log.e("TYPE CASTE HERE", ":::")
                val productDetails = (data as ProductDetailResult)
                Log.e("TYPE CASTED", ":::" + productDetails.brandName)
                productDetails.skuReviewCount = "${productDetails.skuReviewCount} Reviews"
                sendDataToView(serviceId,productDetails)
            }
        }
    }

    private fun sendDataToView(serviceId: Int, productDetailResult: ProductDetailResult) {
        apiResponse.value =
            ApiResposne(productDetailResult = productDetailResult,serviceID = serviceId)
    }

    override fun onFailure(msg: String?) {

    }
}