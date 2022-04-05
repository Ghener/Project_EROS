 package com.example.automatedtaskscheduler

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

 class Setup : AppCompatActivity() {
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_setup)

         val rank = resources.getStringArray(R.array.ranking)

         val schoolRank = findViewById<View>(R.id.spinnerSchool) as Spinner
         val familyRank = findViewById<View>(R.id.spinnerFamily) as Spinner
         val personalRank = findViewById<View>(R.id.spinnerPersonal) as Spinner

         val myAdapter = ArrayAdapter(
             this@Setup,
             android.R.layout.simple_list_item_1, resources.getStringArray(R.array.ranking)
         )
         myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         schoolRank.adapter = myAdapter
         familyRank.adapter = myAdapter
         personalRank.adapter = myAdapter

         val schoolHours = findViewById<View>(R.id.spinnerSchoolHours) as Spinner
         val familyHours = findViewById<View>(R.id.spinnerFamilyHours) as Spinner
         val personalHours = findViewById<View>(R.id.spinnerPersonalHours) as Spinner

         val adapterHours = ArrayAdapter(
             this@Setup,
             android.R.layout.simple_list_item_1, resources.getStringArray(R.array.hours)
         )
         adapterHours.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
         schoolHours.adapter = adapterHours
         familyHours.adapter = adapterHours
         personalHours.adapter = adapterHours


         val buttonSave = findViewById<View>(R.id.button) as Button


         buttonSave.setOnClickListener(){
             val schoolHourSelected = schoolHours.selectedItem
             val schoolRankSelected = schoolRank.selectedItem
             println(schoolHourSelected)
             println(schoolRankSelected)
         }
     }
 }

