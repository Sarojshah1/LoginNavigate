package com.example.loginnavigate.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import com.example.loginnavigate.R
import com.example.loginnavigate.databinding.ActivityButtonFragmentBinding

class DialogBaseFragment : AppCompatActivity() {
    private lateinit var dialogBaseBinding: ActivityButtonFragmentBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        dialogBaseBinding=ActivityButtonFragmentBinding.inflate(layoutInflater)
        setContentView(dialogBaseBinding.root)

        dialogBaseBinding.button3.setOnClickListener {
            var fragmentManager:FragmentManager=supportFragmentManager
            var myDialogFragment=DataFragment()
            myDialogFragment.isCancelable=false
            myDialogFragment.show(fragmentManager,"DataFragment")
        }
    }
    fun getUserData(username:String,age:Int){
        dialogBaseBinding.textView2.text=username
        dialogBaseBinding.textView3.text=age.toString()

    }

}