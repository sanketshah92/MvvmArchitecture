package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.ProductVolumeAdapterLayoutBinding
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.Volume

class VolumeRecyclerViewAdapter(var context: Context?, var volume: List<Volume>) :
    RecyclerView.Adapter<VolumeRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding: ProductVolumeAdapterLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.product_volume_adapter_layout,
            parent,
            false
        )

        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return volume.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(volume = volume[position])
        /*holder.binding.vol1.setOnClickListener(View.OnClickListener {
            for (i in 0 until volume.size) {
                volume[i].isSelected = position == i
            }
            notifyDataSetChanged()
        })*/

    }


    class ViewHolder(val itemViewBinding: ProductVolumeAdapterLayoutBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        val binding = itemViewBinding
        fun bindData(volume: Volume) {
            itemViewBinding.data = volume
        }
    }

}
