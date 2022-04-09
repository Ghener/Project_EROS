package com.example.automatedtaskscheduler

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASENAME = "EROS"
val TABLENAME = "User_Settings"
val COL_ID = "id"
val COL_SCHOOL_RANK = "schoolRank"
val COL_FAMILY_RANK = "familyRank"
val COL_PERSONAL_RANK = "personalRank"
val COL_SCHOOL_HOUR = "schoolHOUR"
val COL_FAMILY_HOUR = "familyHOUR"
val COL_PERSONAL_HOUR = "personalHOUR"



class DataBaseHandler(var context: Context) : SQLiteOpenHelper(context, DATABASENAME, null,
    1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable =
            "CREATE TABLE $TABLENAME ($COL_ID INTEGER PRIMARY KEY AUTOINCREMENT,$COL_SCHOOL_RANK INTEGER,$COL_FAMILY_RANK INTEGER,$COL_PERSONAL_RANK INTEGER,$COL_SCHOOL_HOUR VARCHAR(256),$COL_FAMILY_HOUR VARCHAR(256),$COL_PERSONAL_HOUR VARCHAR(256) )"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(user_setting: User_Setting) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COL_SCHOOL_RANK, user_setting.schoolRank)
        contentValues.put(COL_FAMILY_RANK, user_setting.familyRank)
        contentValues.put(COL_PERSONAL_RANK, user_setting.personalRank)

        contentValues.put(COL_SCHOOL_HOUR, user_setting.schoolHOUR)
        contentValues.put(COL_FAMILY_HOUR, user_setting.familyHOUR)
        contentValues.put(COL_PERSONAL_HOUR, user_setting.personalHOUR)

        val result = database.insert(TABLENAME, null, contentValues)
        if(result == (0).toLong()){
            println("FAILED")
        }
        else{
            println("SUCCESS")

        }
    }
}
