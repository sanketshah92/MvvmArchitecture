package assignment.demoapplication.com.mvvmarchitecture.base

import android.util.Log
import androidx.lifecycle.MutableLiveData
import assignment.demoapplication.com.mvvmarchitecture.model.ResponseWrapper
import assignment.demoapplication.com.mvvmarchitecture.network.APIinterface
import com.google.gson.Gson
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import javax.inject.Inject

open class BaseRepository {

    @Inject
    lateinit var apIinterface: APIinterface
    internal var disposable: Disposable? = null
    val networkStream: MutableLiveData<ResponseWrapper> = MutableLiveData()
    fun networkCall(
        apiMethod: Int,
        url: String,
        resultClass: Class<*>,
        requestObj: Any? = null,
        serviceID: Int
    ) {
        APIinterface.callBack(apIinterface, apiMethod, url, requestObj)
            ?.subscribeOn(Schedulers.newThread())
            ?.observeOn(AndroidSchedulers.mainThread())
            ?.subscribe(object : Observer<ResponseWrapper> {
                override fun onComplete() {

                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onNext(response: ResponseWrapper) {
                    response.serviceId = serviceID
                    response.data = getResultObj(response.data, resultClass)
                    networkStream.value = response
                    //handleResponse(response.data)

                }

                override fun onError(e: Throwable) {

                }

            })
    }

    private fun getResultObj(result: Any, resultClass: Class<*>): Any {
        val gson = Gson()
        val str = gson.toJson(result, result.javaClass)
        if (str.startsWith("[") && str.endsWith("]")) {
            val jsonArray = JSONArray(str)
            val resultObj: Any = gson.fromJson(jsonArray.toString(), resultClass)
            return resultObj
        } else {
            val jsonObject = JSONObject(str)
            val resultObj: Any = gson.fromJson(jsonObject.toString(), resultClass)
            return resultObj
        }
    }

    /*abstract fun handleResponse(responseObj: Any):MutableLiveData<ResponseWrapper>

    abstract fun handleError(error: Throwable)
*/
}