package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.CleanBeautyAdapterLayoutBinding

class CleanBeautyImageAdapter(var context: Context?, var imageUrl: List<String>) :
    RecyclerView.Adapter<CleanBeautyImageAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return imageUrl.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(imageUrl = imageUrl[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: CleanBeautyAdapterLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.clean_beauty_adapter_layout,
            parent,
            false
        )

        return ViewHolder(binding)
    }

    class ViewHolder(val itemViewBinding: CleanBeautyAdapterLayoutBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindData(imageUrl: String) {
            itemViewBinding.imageUrl = imageUrl
        }
    }
}