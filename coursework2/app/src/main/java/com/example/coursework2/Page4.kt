package com.example.coursework2

import android.content.ContentValues.TAG
import android.database.sqlite.SQLiteDatabase
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class Page4 : AppCompatActivity() {


    lateinit var database: SQLiteDatabase
    val suggestionList = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page4)

        val searchBar = findViewById<AutoCompleteTextView>(R.id.searchTextField)
        val searchBtn = findViewById<Button>(R.id.searchButton)

        val dbHelper = MyHelper(this)
        database = dbHelper.readableDatabase

        searchBar.threshold = 1

        searchBar.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            Toast.makeText(applicationContext, "Selected: $selectedItem", Toast.LENGTH_SHORT).show()  //Toast notification


        }

        searchBtn.setOnClickListener {
            val query = searchBar.text.toString()
            retrieveSuggestions(query)
            searchBar.showDropDown()
        }
    }


    private fun retrieveSuggestions(query: String) {
        suggestionList.clear()
        val cursor = database.rawQuery("SELECT * FROM MEAL_TABLE WHERE MEAL LIKE '%$query%'", null)
        

        if (cursor.moveToFirst()) {
            val columnIndex = cursor.getColumnIndex("MEAL")
            val imageIndex = cursor.getColumnIndex("IMAGE_SOURCE")
            if (columnIndex >= 0 && imageIndex >= 0 ) {
                do {
                    val suggestion = cursor.getString(columnIndex)
                    val image = cursor.getString(imageIndex)
                    suggestionList.add("$suggestion|$image")

                } while (cursor.moveToNext())
            } else {
                Log.e(TAG, "Column does not exist in the cursor")
            }
        } else {
            Log.e(TAG, "Cursor is empty")
        }
        cursor.close()

        val adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, suggestionList)
        findViewById<AutoCompleteTextView>(R.id.searchTextField).setAdapter(adapter)


        //concatenate the meal names into a string with a newline delimiter
       // val mealText = suggestionList.joinToString("\n")
        val mealText = suggestionList.joinToString("\n") { it.split("|")[0] }
        val imageUrls = suggestionList.joinToString("\n") { it.split("|")[1] }

        // set the resulting string as the text of the TextView
        val mealTextView = findViewById<TextView>(R.id.selectedMealTextView)
        mealTextView.text = mealText

        val mealImageView = findViewById<ImageView>(R.id.thumbImageView)
        if (imageUrls.isNotEmpty()) {
            // load the image using Glide library
            Glide.with(this)
                .load(imageUrls)
                .into(mealImageView)
        } else {
            // clear the image view if there's no image URL
            mealImageView.setImageResource(0)
        }


    }

}




