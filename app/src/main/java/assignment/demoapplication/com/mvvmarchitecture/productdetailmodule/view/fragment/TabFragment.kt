package assignment.demoapplication.com.mvvmarchitecture.productdetailmodule.view.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import assignment.demoapplication.com.mvvmarchitecture.R
import assignment.demoapplication.com.mvvmarchitecture.databinding.FragmentTabLayoutBinding

/**
 * A simple [Fragment] subclass.
 */
class TabFragment constructor(val description: String = "") : Fragment() {
    lateinit var binding: FragmentTabLayoutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater,
                R.layout.fragment_tab_layout, container, false)
        binding.data = description
        return binding.root
    }


}
