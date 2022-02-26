package com.example.sampleproject2

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.sampleproject2.databinding.ActivityConsultBinding

class ConsultActivity : AppCompatActivity() {
    lateinit var binding : ActivityConsultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConsultBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        if(savedInstanceState!= null){
            var myText = savedInstanceState.getString("textView1Text")
            binding.textView.text = myText
        }
        initViews()
    }
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("textView1Text" , binding.textView.text.toString())
        super.onSaveInstanceState(outState)
    }

    private fun initViews() {
        var id = intent.getIntExtra("id" , -1)
        if (id == -1){
            binding.textViewDoctorCalls.text = "ٔدکتر شما پیدا نشد"
        }else {
            var myDoctor = Hospital.getDoctor(id)
            binding.textViewDoctorCalls.text = "دکتر ${myDoctor?.name} با شما تماس خواهد گرفت"
            binding.buttonDrCall.isEnabled  = myDoctor?.onlineStatus == OnlineStatus.Online
        }
        binding.buttonDrCall.setOnClickListener {
//            getUserNameAndTel()
//            openCheckActivity()
            binding.textView.text = "پیام من"
        }
        if (!getFromShared_name().isNullOrEmpty() ){
            binding.editTextName.visibility = View.GONE
        }
        if (!getFromShared_tel().isNullOrEmpty() ){
            binding.editTextTel.visibility= View.GONE
        }
    }

    private fun openCheckActivity() {
        val intent = Intent(this , CheckPatientActivity::class.java)
        startForResult.launch(intent)
    }

    private fun getUserNameAndTel() {
        var username = binding.editTextName.text.toString()
        var userTel = binding.editTextTel.text.toString()
        saveInShared(username , userTel)
    }

    private fun saveInShared(username: String, userTel: String) {
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putString("name" , username)
        editor.putString("tel" , userTel)
        editor.apply()
    }
    private fun getFromShared_name() : String?{
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        var name = sharedPreferences.getString("name" , "")
        return name
    }
    private fun getFromShared_tel() : String?{
        val sharedPreferences: SharedPreferences =
            getSharedPreferences("kotlinSharedPreference", Context.MODE_PRIVATE)
        var tel = sharedPreferences.getString("tel" , "")
        return tel
    }
    val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val intent = result.data
            val isOk =  intent?.getBooleanExtra("isOk", false)
            Toast.makeText(this ,"isOk value is : " + isOk , Toast.LENGTH_SHORT).show()
            isOk?.let{
                if(it)
                    Toast.makeText(this , "الان دکتر بهت زنگ می زنه" , Toast.LENGTH_SHORT).show()

            }
        }
    }
}