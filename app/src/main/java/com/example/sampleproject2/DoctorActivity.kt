package com.example.sampleproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject2.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorBinding.inflate(layoutInflater)
        var view=binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {
        Hospital.setTestData()
        var myDoctor=Hospital.doctorList[0]
        binding.textViewNeme.text=myDoctor.name
        binding.textViewExportise.text=myDoctor.field
        binding.textViewconnect.text=myDoctor.onlineStatus.toString()


    }

}