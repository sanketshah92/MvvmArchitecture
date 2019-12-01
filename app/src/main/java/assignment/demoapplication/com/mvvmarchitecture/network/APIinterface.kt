package assignment.demoapplication.com.mvvmarchitecture.network

import assignment.demoapplication.com.mvvmarchitecture.model.ResponseWrapper
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiMethod.Companion.GET_METHOD
import assignment.demoapplication.com.mvvmarchitecture.util.Constants.ApiMethod.Companion.POST_METHOD
import io.reactivex.Observable
import retrofit2.http.*

interface APIinterface {

    @POST("{url}")
    fun postMethod(
        @Path(
            value = "url",
            encoded = true
        ) methodUrl: String, @Body requestObj: Any
    ): Observable<ResponseWrapper>

    @GET("{url}")
    fun getMethod(@Path(value = "url", encoded = true) methodUrl: String , @QueryMap parameters: Map<String, String>): Observable<ResponseWrapper>


    companion object {
        fun callBack(
            apiCallInterface: APIinterface?,
            apiMethod: Int,
            url: String,
            requestObj: Any?,
            parameters: Map<String, String>
        ): Observable<ResponseWrapper>? {
            var call: Observable<ResponseWrapper>? = null
            when (apiMethod) {
                GET_METHOD -> call = apiCallInterface?.getMethod(url,parameters)
                POST_METHOD -> call = apiCallInterface?.postMethod(url, requestObj!!)
            }
            return call
        }
    }

}