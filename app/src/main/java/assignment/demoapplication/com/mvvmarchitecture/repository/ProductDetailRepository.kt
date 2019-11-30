package assignment.demoapplication.com.mvvmarchitecture.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import assignment.demoapplication.com.mvvmarchitecture.base.BaseRepository
import assignment.demoapplication.com.mvvmarchitecture.model.ResponseWrapper
import assignment.demoapplication.com.mvvmarchitecture.network.APIinterface
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.ProductDetailResult
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiMethod.Companion.GET_METHOD
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiUrl.Companion.GET_PRODUCT_DETAIL_URL
import com.google.gson.Gson
import javax.inject.Inject

class ProductDetailRepository @Inject constructor(val service: APIinterface) : BaseRepository() {

    fun getProductDetail(serviceID: Int) {
        networkCall(
            GET_METHOD,
            GET_PRODUCT_DETAIL_URL,
            resultClass = ProductDetailResult::class.java,
            serviceID = serviceID
        )
    }


}