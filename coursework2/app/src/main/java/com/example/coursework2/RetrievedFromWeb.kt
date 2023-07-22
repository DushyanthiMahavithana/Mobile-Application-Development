package com.example.coursework2

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class RetrievedFromWeb : AppCompatActivity(){
    private val baseUrl = "https://www.themealdb.com/api/json/v1/1/search.php?s="
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var resultTextView: TextView
    private lateinit var requestQueue: RequestQueue


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrieved_from_web)

        searchEditText = findViewById(R.id.search_input)
        searchButton = findViewById(R.id.search_button)
        resultTextView = findViewById(R.id.meal_from_web)
        requestQueue = Volley.newRequestQueue(this)

        searchButton.setOnClickListener {
            val searchString = searchEditText.text.toString()
            searchMeals(searchString)
        }


    }

    private fun searchMeals(searchString: String) {
        val url = "$baseUrl$searchString"  // The complete URL with the user-provided search string
        val jsonObjectRequest = JsonObjectRequest(   //new JSON request using Volley
            Request.Method.GET, url, null,
            { response ->
                try {
                    val mealsArray = response.getJSONArray("meals")
                    val mealsList = mutableListOf<String>()

                    for (i in 0 until mealsArray.length()) {
                        val mealObject = mealsArray.getJSONObject(i)
                        val mealName = mealObject.getString("strMeal")
                        mealsList.add(mealName)
                    }

                    // Join the meal names into a single string and display it in the result TextView
                    val mealsString = mealsList.joinToString("\n")
                    resultTextView.text = mealsString
                } catch (e: JSONException) {
                    e.printStackTrace()
                }
            },
            { error ->
                error.printStackTrace()
            }
        )

        requestQueue.add(jsonObjectRequest)  // Add the JSON request to the Volley request queue
    }

}