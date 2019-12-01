package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.QuestionAnswerAdapterLayoutBinding
import assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.model.Qna

class QuestionAnswerAdapter (var context: Context?, var qna: List<Qna>) :
    RecyclerView.Adapter<QuestionAnswerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): QuestionAnswerAdapter.ViewHolder {
        val binding: QuestionAnswerAdapterLayoutBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.question_answer_adapter_layout,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 3
    }

    override fun onBindViewHolder(holder: QuestionAnswerAdapter.ViewHolder, position: Int) {
        holder.bindData(qna[position])
    }

    class ViewHolder(val itemViewBinding: QuestionAnswerAdapterLayoutBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root) {
        fun bindData(qna: Qna) {
            itemViewBinding.data = qna
        }
    }
}