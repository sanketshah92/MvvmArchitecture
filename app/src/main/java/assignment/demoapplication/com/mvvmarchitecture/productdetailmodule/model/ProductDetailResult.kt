package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model


data class ProductDetailResult(
    val blogs: List<Any>,
    val brandName: String,
    val brandUrlLink: String,
    val campaign: Any,
    val categoryName: String,
    val categoryUrlLink: String,
    val cleanBeauty: CleanBeauty,
    val deepLinkUrl: String,
    val defaultPrice: String,
    val deliveryTitle: String,
    val facets: List<Facet>,
    val inBasket: Boolean,
    val inWishList: Boolean,
    val isAvailable: Boolean,
    val isDiscontinued: Boolean,
    val listPrice: Int,
    val parentCategoryName: String,
    val productCombo: List<ProductCombo>,
    val qna: List<Qna>,
    val reviews: List<Review>,
    val similarItems: Any,
    val skuAverageRating: Float,
    val skuBatchNumber: Int,
    val skuDiscPercentage: Int,
    val skuId: String,
    val skuImageUrls: List<String>,
    val skuName: String,
    val skuParentCode: Any,
    val skuPromoText: Any,
    var skuReviewCount: String,
    val skuTag: Any,
    val skuUrlLink: String,
    val superCategoryName: String,
    val tagImageUrlGrid: Any,
    val tagImageUrlList: Any,
    val variantColor: Any,
    val variantColorCode: Any,
    val variants: Variants,
    val volume: Any
)

data class Answer(
    val answerText: String,
    val postedDate: Long,
    val userNickname: String
)

data class CleanBeauty(
    val cleanBeautyImageUrl: Any,
    val description: Any,
    val imageUrls: List<String>,
    val subTitle: String,
    val title: String
)

data class Facet(
    val content: String,
    val contentUrl: String,
    val imageUrl: Any,
    val priority: Int,
    val title: String,
    val type: String
)

data class ProductCombo(
    val defaultPrice: String,
    val listPrice: String,
    val sku1: Sku1,
    val sku2: Sku2
)

data class Qna(
    val answer: Answer,
    val postedDate: Long,
    val queryText: String,
    val userNickname: String
)

data class Review(
    val postedDate: Long,
    val reviewText: String,
    val reviewTitle: String,
    val skuRating: Int,
    val userNickname: String
)

data class Sku1(
    val brandUrlLink: String,
    val categoryName: String,
    val categoryUrlLink: String,
    val deepLinkUrl: String,
    val defaultPrice: Int,
    val inWishList: Boolean,
    val isAvailable: Boolean,
    val listPrice: Int,
    val parentCategoryName: String,
    val skuAverageRating: Double,
    val skuDiscPercentage: Int,
    val skuId: String,
    val skuImageUrl: String,
    val skuName: String,
    val skuPromoText: Any,
    val skuTag: Any,
    val skuUrlLink: String,
    val superCategoryName: String,
    val tagImageUrlGrid: Any,
    val tagImageUrlList: Any
)

data class Sku2(
    val brandUrlLink: String,
    val categoryName: String,
    val categoryUrlLink: String,
    val deepLinkUrl: String,
    val defaultPrice: Int,
    val inWishList: Boolean,
    val isAvailable: Boolean,
    val listPrice: Int,
    val parentCategoryName: String,
    val skuAverageRating: Double,
    val skuDiscPercentage: Int,
    val skuId: String,
    val skuImageUrl: String,
    val skuName: String,
    val skuPromoText: Any,
    val skuTag: Any,
    val skuUrlLink: String,
    val superCategoryName: String,
    val tagImageUrlGrid: Any,
    val tagImageUrlList: Any
)


data class Variants(
    val flavour: List<Any>,
    val shade: List<Any>,
    val volume: List<Volume>
)

data class Volume(
    val code: Any,
    val family: Any,
    val isAvailable: Boolean,
    var isSelected: Boolean,
    val name: Any,
    val skuId: String,
    val skuUrlLink: String,
    val volume: String,
    val volumes: Any
)

