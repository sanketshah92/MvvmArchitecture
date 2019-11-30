package assignment.demoapplication.com.mvvmarchitecture.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import assignment.demoapplication.com.mvvmarchitecture.model.ResponseWrapper

 abstract class BaseViewModel(val respository : BaseRepository) : ViewModel() {
    abstract fun onSuccess(data: Any?,serviceId:Int)
    abstract fun onFailure(msg: String?)

    init {
        observeNetworkStream()
    }

    private fun observeNetworkStream() {
        if (!respository.networkStream.hasObservers())
            respository.networkStream.observeForever {
                if (it.data != null)
                    onSuccess(data = it.data,serviceId = it.serviceId)
                else
                    onFailure(it.message)

            }
    }

    fun getNetworkStream(): MutableLiveData<ResponseWrapper> {
        return respository.networkStream
    }
}