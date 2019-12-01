package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.ReviewRatingAdapterLayoutBinding
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.Review

class ReviewAndRatingAdapter (var context: Context?, var review: List<Review>) :
    RecyclerView.Adapter<ReviewAndRatingAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReviewAndRatingAdapter.ViewHolder {
        val binding: ReviewRatingAdapterLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.review_rating_adapter_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return review.size
    }

    override fun onBindViewHolder(holder: ReviewAndRatingAdapter.ViewHolder, position: Int) {
        holder.bindData(review = review[position])
    }

    class ViewHolder(val itemViewBinding: ReviewRatingAdapterLayoutBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindData(review: Review) {
            itemViewBinding.data = review
        }
    }
}