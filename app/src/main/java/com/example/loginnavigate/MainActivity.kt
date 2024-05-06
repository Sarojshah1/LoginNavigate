package com.example.loginnavigate

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginnavigate.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    lateinit var sharedPreferences: SharedPreferences
    var email:String?=null
    var password:String?=null
    var remember:Boolean?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        mainBinding=ActivityMainBinding.inflate(layoutInflater)
        var view=mainBinding.root
        setContentView(view)
        mainBinding.Register.setOnClickListener {
            sharedPreferences=this.getSharedPreferences("uservalue", MODE_PRIVATE)
            email=mainBinding.emailtext.text.toString()
            password=mainBinding.password.text.toString()
            remember=mainBinding.Remember.isChecked
            var editor=sharedPreferences.edit()
            editor.putString("Email",email)
            editor.putString("Password",password)
            editor.putBoolean("remember",remember!!)
            editor.apply()
            Toast.makeText(applicationContext,"Data saved", Toast.LENGTH_LONG).show()

        }
        mainBinding.Login.setOnClickListener {
            email=sharedPreferences.getString("Email","")
            password=sharedPreferences.getString("Password","")

            if(email.toString() == mainBinding.emailtext.text.toString() && password.toString()==mainBinding.password.text.toString()){
                var intent= Intent(this@MainActivity,RecyclerActivity::class.java)
                startActivity(intent)
            }

        }

    }

    override fun onPause() {
        sharedPreferences=this.getSharedPreferences("uservalue", MODE_PRIVATE)
        email=mainBinding.emailtext.text.toString()
        password=mainBinding.password.text.toString()
        remember=mainBinding.Remember.isChecked
        var editor=sharedPreferences.edit()
        editor.putString("Email",email)
        editor.putString("Password",password)
        editor.putBoolean("remember",remember!!)
        editor.apply()
        Toast.makeText(applicationContext,"Data saved", Toast.LENGTH_LONG).show()
        super.onPause()
    }

    override fun onResume() {
        sharedPreferences=this.getSharedPreferences("uservalue", MODE_PRIVATE)
        email=sharedPreferences.getString("Email","")
        password=sharedPreferences.getString("Password","")
        remember=sharedPreferences.getBoolean("remember",false)

        if (remember==true){
            mainBinding.emailtext.setText(email)
            mainBinding.password.setText(password)
            mainBinding.Remember.isChecked=remember!!

        }

        super.onResume()
    }


}