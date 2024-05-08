package com.example.loginnavigate.fragment

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.loginnavigate.R
import com.example.loginnavigate.databinding.ActivityBaseBinding
import com.example.loginnavigate.databinding.ActivityMainBinding


class baseActivity : AppCompatActivity() {
   lateinit var baseBinding: ActivityBaseBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_base)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        baseBinding= ActivityBaseBinding.inflate(layoutInflater)
        var view=baseBinding.root
        setContentView(view)
        replaceFragment(BlankFragment(),true)

        baseBinding.button.setOnClickListener {
            replaceFragment(BlankFragment(),false)

        }
        baseBinding.button2.setOnClickListener {
            replaceFragment(BlankFragment2(),false)
        }
    }

    private fun replaceFragment(fragment:Fragment,add:Boolean) {
        val fragmentManager:FragmentManager=supportFragmentManager
        val fragmentTransaction:FragmentTransaction=fragmentManager.beginTransaction()
        if(add==true){
            fragmentTransaction.add(R.id.framelayout,fragment)

        }else{
        fragmentTransaction.replace(R.id.framelayout,fragment)
        }
        fragmentTransaction.commit()

    }
}