package com.example.sampleproject2
import java.util.*
import kotlin.collections.ArrayList

object Hospital{
    val doctorList = arrayListOf<Doctor>()
    val consultancyList = arrayListOf(
        Consultancy(1 , 30 , 100000, ConsultancyType.Phone),
        Consultancy(2 , 60 , 250000, ConsultancyType.Video),
        Consultancy(3 , 90 , 300000, ConsultancyType.Phone)
    )
    fun getDoctor(id : Int) : Doctor?{
        for (doctor in doctorList){
            if (doctor.id == id){
                return doctor
            }
        }
        return null
    }
    fun setTestDate(){
        doctorList.clear()
        doctorList.add(Doctor(1 , "Dr. sara" ,  OnlineStatus.Online , "روانشناسی و مشاوره" ))
        doctorList.add(Doctor(2 , "Dr. rostam" , OnlineStatus.Online , "روانشناسی و مشاوره" ))
    }
}

data class Doctor ( val id : Int,
                    val name : String ,
                    var onlineStatus : OnlineStatus ,
                    var field : String ,
                    var imageId : Int? = null
)
enum class OnlineStatus{
    Online, Offline
}

data class Consultancy (val id : Int,
                        val time : Int,
                        val price : Int,
                        val type : ConsultancyType
)

enum class ConsultancyType{
    Phone , Video
}


data class Question(var description : String , val answer : Boolean , var cheated : Boolean)

object Questionair{
    var qMap : ArrayList<Question> = arrayListOf( Question("", true , false) ,
        Question("", true , false) ,
        Question("", true , false) )
}