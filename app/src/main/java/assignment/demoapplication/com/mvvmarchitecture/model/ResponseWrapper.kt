package assignment.demoapplication.com.mvvmarchitecture.model

data class ResponseWrapper(
    var message: String,
    var data : Any,
    var serviceId: Int
)
