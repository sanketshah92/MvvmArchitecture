package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.ComboProductAdapterLayoutBinding
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.ProductCombo

class ComboRecyclerViewAdapter (var context: Context?, var productCombo: List<ProductCombo>) :
    RecyclerView.Adapter<ComboRecyclerViewAdapter.ViewHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding: ComboProductAdapterLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.combo_product_adapter_layout,
            parent,
            false
        )

        return ViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return productCombo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindData(productCombo[position])
    }

    class ViewHolder(val itemViewBinding: ComboProductAdapterLayoutBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindData(productCombo: ProductCombo) {
            itemViewBinding.data = productCombo
        }
    }
}