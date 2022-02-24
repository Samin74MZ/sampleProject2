package com.example.sampleproject2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sampleproject2.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding: ActivityDoctorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDoctorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}