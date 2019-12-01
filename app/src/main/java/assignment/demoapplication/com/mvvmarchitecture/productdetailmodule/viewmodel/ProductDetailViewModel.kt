package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.viewmodel

import android.util.Log
import android.util.SparseArray
import androidx.lifecycle.MutableLiveData
import assignment.demoapplication.com.mvvmarchitecture.base.BaseViewModel
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.ApiResposne
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.ProductDetailResult
import assignment.demoapplication.com.mvvmarchitecture.repository.ProductDetailRepository
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiServiceID.Companion.GET_PRODUCT_DETAIL_SERVICE_ID
import assignment.demoapplication.com.mvvmarchitecture.util.DD_MMMM_YYYY_format
import assignment.demoapplication.com.mvvmarchitecture.util.DD_MMMM_format
import assignment.demoapplication.com.mvvmarchitecture.util.getDateFromLong
import java.util.HashMap
import javax.inject.Inject

class ProductDetailViewModel @Inject constructor(private val repository: ProductDetailRepository) :
    BaseViewModel(repository) {

    val apiResponse = MutableLiveData<ApiResposne>()

    fun getProductDetail() {
        val parameters = LinkedHashMap<String,String>()
        parameters.put("app","web")
        parameters.put("version","3.0.0")
        parameters.put("shop","false")
        repository.getProductDetail(GET_PRODUCT_DETAIL_SERVICE_ID,parameters)
    }

    override fun onSuccess(data: Any?, serviceId: Int) {
        when (serviceId) {
            GET_PRODUCT_DETAIL_SERVICE_ID -> {
                Log.e("TYPE CASTE HERE", ":::")
                val productDetails = (data as ProductDetailResult)
                Log.e("TYPE CASTED", ":::" + productDetails.brandName)
                sendDataToView(serviceId,processData(productDetails))
            }
        }
    }

    private fun processData(productDetails: ProductDetailResult) : ProductDetailResult{

        productDetails.skuReviewCount = "${productDetails.skuReviewCount} Reviews"

        for (qna in productDetails.qna){
           qna.postedBy = "By ${qna.userNickname}, ${getDateFromLong(qna.postedDate, DD_MMMM_format)}"
            qna.answerPostedBy = "By ${qna.answer.userNickname}, ${getDateFromLong(qna.answer.postedDate, DD_MMMM_format)}"
        }

        for (review in productDetails.reviews){
            review.reviewPostedBy = "By ${review.userNickname}, ${getDateFromLong(review.postedDate, DD_MMMM_YYYY_format)}"
        }
        return productDetails
    }

    private fun sendDataToView(serviceId: Int, productDetailResult: ProductDetailResult) {
        apiResponse.value =
            ApiResposne(productDetailResult = productDetailResult,serviceID = serviceId)
    }

    override fun onFailure(msg: String?) {

    }
}