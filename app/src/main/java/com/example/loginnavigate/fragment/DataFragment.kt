package com.example.loginnavigate.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.loginnavigate.databinding.FragmentDialogBinding

class DataFragment : DialogFragment() {
    lateinit var  dialogBinding: FragmentDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialogBinding=FragmentDialogBinding.inflate(inflater,container,false)

        dialogBinding.button4.setOnClickListener {
            dialog!!.dismiss()

        }
        dialogBinding.button5.setOnClickListener {
            val username:String=dialogBinding.editTextText.text.toString()
            val age:Int=dialogBinding.editTextText3.text.toString().toInt()
            val dialogBaseFragment:DialogBaseFragment= activity as DialogBaseFragment
            dialogBaseFragment.getUserData(username,age)
            dialog!!.dismiss()


        }
        return dialogBinding.root

    }


}