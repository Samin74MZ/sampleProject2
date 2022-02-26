package com.example.sampleproject2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sampleproject2.databinding.ActivityDoctorBinding

class DoctorActivity : AppCompatActivity() {
    lateinit var binding : ActivityDoctorBinding
    var qNumber  = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        initViews()
    }

    private fun initViews() {

        Hospital.setTestDate()
        var myDoctor = Hospital.doctorList[0]
        binding.textViewName.text = myDoctor.name
        binding.textViewField.text = myDoctor.field
        binding.textViewOnlineStatus.text = myDoctor.onlineStatus.toString()

        var cons1 = Hospital.consultancyList[0]
        binding.textViewConsultancy.text = " مشاوره تلفنی " + cons1.time + " دقیقه ای "
        binding.textViewConsultancy.text = " مشاوره تلفنی " + cons1.time + " دقیقه ای "
        binding.textViewConsultancyPrice.text = cons1.price.toString() +  " تومان "

        binding.llConsultancy.setOnClickListener {
            Toast.makeText(this , "cunsultancy is chosen" , Toast.LENGTH_SHORT).show()
            val intent = Intent(this , ConsultActivity::class.java)
            intent.putExtra("id" , myDoctor.id)
            startActivity(intent)

            // startForResult.launch(intent)
        }
    }
    fun call(){
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:09124332893")
        startActivity(callIntent)
    }




}