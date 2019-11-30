package assignment.demoapplication.com.mvvmarchitecture.util

class Constants {

    companion object {
        val BASEURL = "https://staging.healthandglow.com/api/"

    }

    interface ApiMethod {
        companion object {
            val GET_METHOD = 0
            val POST_METHOD = 1
        }
    }

    interface ApiUrl {
        companion object {
            val GET_PRODUCT_DETAIL_URL = "catalog/product/v6/106,999/533953"
        }
    }

    interface ApiServiceID {
        companion object {
            val GET_PRODUCT_DETAIL_SERVICE_ID = 1
        }
    }
}