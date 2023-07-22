package com.example.coursework2

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.coursework2.data.UserViewModel

class Page2 : AppCompatActivity(){
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page2)

        var helper = MyHelper(applicationContext)  //helper instance using the application context
        var db = helper.readableDatabase // Get a readable database instance from the helper
        var rs = db.rawQuery("SELECT*FROM MEAL_TABLE",null) // Execute a raw SQL query to retrieve all rows from the MEAL_TABLE

        var next1 = findViewById<Button>(R.id.nextPage1)
        next1.setOnClickListener {
            var cv = ContentValues()  // Create a new ContentValues object to hold values to be inserted into the database
            Toast.makeText(applicationContext,"Done !", Toast.LENGTH_LONG).show()

            // Put the value of the EditText with an ID into the ContentValues object
            cv.put("MEAL",findViewById<EditText>(R.id.mealId).text.toString())
            cv.put("DRINK_ALTERNATE",findViewById<EditText>(R.id.drinkId).text.toString())
            cv.put("CATEGORY",findViewById<EditText>(R.id.categoryId).text.toString())
            cv.put("AREA",findViewById<EditText>(R.id.areaId).text.toString())
            cv.put("INSTRUCTIONS",findViewById<EditText>(R.id.instructionsId).text.toString())
            cv.put("MEAL_THUMB",findViewById<EditText>(R.id.mealThumbId).text.toString())
            cv.put("TAGS",findViewById<EditText>(R.id.tagsId).text.toString())
            cv.put("YOUTUBE",findViewById<EditText>(R.id.youtubeId).text.toString())
            cv.put("INGREDIENT1",findViewById<EditText>(R.id.Ing1).text.toString())
            cv.put("INGREDIENT2",findViewById<EditText>(R.id.Ing2).text.toString())
            cv.put("INGREDIENT3",findViewById<EditText>(R.id.Ing3).text.toString())
            cv.put("INGREDIENT4",findViewById<EditText>(R.id.Ing4).text.toString())
            cv.put("INGREDIENT5",findViewById<EditText>(R.id.Ing5).text.toString())
            cv.put("INGREDIENT6",findViewById<EditText>(R.id.Ing6).text.toString())
            cv.put("INGREDIENT7",findViewById<EditText>(R.id.Ing7).text.toString())
            cv.put("INGREDIENT8",findViewById<EditText>(R.id.Ing8).text.toString())
            cv.put("INGREDIENT9",findViewById<EditText>(R.id.Ing9).text.toString())
            cv.put("INGREDIENT10",findViewById<EditText>(R.id.Ing10).text.toString())
            cv.put("MEASURE1",findViewById<EditText>(R.id.Mes1).text.toString())
            cv.put("MEASURE2",findViewById<EditText>(R.id.Mes2).text.toString())
            cv.put("MEASURE3",findViewById<EditText>(R.id.Mes3).text.toString())
            cv.put("MEASURE4",findViewById<EditText>(R.id.Mes4).text.toString())
            cv.put("MEASURE5",findViewById<EditText>(R.id.Mes5).text.toString())
            cv.put("MEASURE6",findViewById<EditText>(R.id.Mes6).text.toString())
            cv.put("MEASURE7",findViewById<EditText>(R.id.Mes7).text.toString())
            cv.put("MEASURE8",findViewById<EditText>(R.id.Mes8).text.toString())
            cv.put("MEASURE9",findViewById<EditText>(R.id.Mes9).text.toString())
            cv.put("MEASURE10",findViewById<EditText>(R.id.Mes10).text.toString())
            cv.put("SOURCE",findViewById<EditText>(R.id.source).text.toString())
            cv.put("IMAGE_SOURCE",findViewById<EditText>(R.id.imgSource).text.toString())
            cv.put("CREATIVE_COMMONS_CONFIRMED",findViewById<EditText>(R.id.creative).text.toString())
            cv.put("DATE_MODIFIED",findViewById<EditText>(R.id.dateModified).text.toString())



            db.insert("MEAL_TABLE",null,cv)  // insert data into the "MEAL_TABLE" using ContentValues object

            // clear the text in Id EditText view
            findViewById<EditText>(R.id.mealId).setText(" ")
            findViewById<EditText>(R.id.drinkId).setText(" ")
            findViewById<EditText>(R.id.categoryId).setText(" ")
            findViewById<EditText>(R.id.areaId).setText(" ")
            findViewById<EditText>(R.id.instructionsId).setText(" ")
            findViewById<EditText>(R.id.mealThumbId).setText(" ")
            findViewById<EditText>(R.id.tagsId).setText(" ")
            findViewById<EditText>(R.id.youtubeId).setText(" ")
            findViewById<EditText>(R.id.Ing1).setText(" ")
            findViewById<EditText>(R.id.Ing2).setText(" ")
            findViewById<EditText>(R.id.Ing3).setText(" ")
            findViewById<EditText>(R.id.Ing4).setText(" ")
            findViewById<EditText>(R.id.Ing5).setText(" ")
            findViewById<EditText>(R.id.Ing6).setText(" ")
            findViewById<EditText>(R.id.Ing7).setText(" ")
            findViewById<EditText>(R.id.Ing8).setText(" ")
            findViewById<EditText>(R.id.Ing9).setText(" ")
            findViewById<EditText>(R.id.Ing10).setText(" ")
            findViewById<EditText>(R.id.Mes1).setText(" ")
            findViewById<EditText>(R.id.Mes2).setText(" ")
            findViewById<EditText>(R.id.Mes3).setText(" ")
            findViewById<EditText>(R.id.Mes4).setText(" ")
            findViewById<EditText>(R.id.Mes5).setText(" ")
            findViewById<EditText>(R.id.Mes6).setText(" ")
            findViewById<EditText>(R.id.Mes7).setText(" ")
            findViewById<EditText>(R.id.Mes8).setText(" ")
            findViewById<EditText>(R.id.Mes9).setText(" ")
            findViewById<EditText>(R.id.Mes10).setText(" ")
            findViewById<EditText>(R.id.source).setText(" ")
            findViewById<EditText>(R.id.imgSource).setText(" ")
            findViewById<EditText>(R.id.creative).setText(" ")
            findViewById<EditText>(R.id.dateModified).setText(" ")

        }
    }
}