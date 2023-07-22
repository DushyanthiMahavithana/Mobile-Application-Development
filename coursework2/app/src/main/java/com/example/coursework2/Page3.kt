package com.example.coursework2

import android.content.ContentValues
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.coursework2.data.User
import org.json.JSONException


class Page3 : AppCompatActivity() {

    private lateinit var search: Button //  search button
    private lateinit var userInput: EditText //  edit text field for user input
    private lateinit var mTextViewResult: TextView // text view to display results
    private lateinit var mQueue: RequestQueue // Declare request queue for API requests
    private lateinit var context: Context // Declare context variable
    private lateinit var InsertDb:Button // Declare button to insert data into database



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_page3)
        context = this

        // Initialize components with their views from the layout
        search = findViewById(R.id.retrieveMealsBtn)
        userInput = findViewById(R.id.editTextTextIngredient)
        mTextViewResult = findViewById(R.id.resultsTextView)
        InsertDb = findViewById<Button>(R.id.saveToDb)


        mQueue = Volley.newRequestQueue(this) // Initialize the request queue with this activity's context


        search.setOnClickListener {
            val input = userInput.text.toString() // Get user input from edit text field
            Log.d("Page3", "User input: $input") // Log user input for debugging purposes
            fetchData(input) // Call method to fetch data from API
        }


}




    private fun fetchData(input: String) {
        val url = "https://www.themealdb.com/api/json/v1/1/search.php?s=$input"
        val request = JsonObjectRequest(Request.Method.GET, url, null,
            { response ->
                try {
                    mTextViewResult.text = "" // clear the TextView before appending new data
                    val userList = mutableListOf<User>() // create a list to store retrieved meals
                    val jsonArray = response.getJSONArray("meals")
                    for (i in 0 until jsonArray.length()) {
                        val mealPrep = jsonArray.getJSONObject(i)
                        val idmeal = mealPrep.getString("idMeal")
                        val meal = mealPrep.getString("strMeal")
                        val drinkAlternate = mealPrep.getString("strDrinkAlternate")
                        val category = mealPrep.getString("strCategory")
                        val area = mealPrep.getString("strArea")
                        val instructions = mealPrep.getString("strInstructions")
                        val mealThumb = mealPrep.getString("strMealThumb")
                        val tags = mealPrep.getString("strTags")
                        val youTube = mealPrep.getString("strYoutube")
                        val ingredient1 = mealPrep.getString("strIngredient1")
                        val ingredient2 = mealPrep.getString("strIngredient2")
                        val ingredient3 = mealPrep.getString("strIngredient3")
                        val ingredient4 = mealPrep.getString("strIngredient4")
                        val ingredient5 = mealPrep.getString("strIngredient5")
                        val ingredient6 = mealPrep.getString("strIngredient6")
                        val ingredient7 = mealPrep.getString("strIngredient7")
                        val ingredient8 = mealPrep.getString("strIngredient8")
                        val ingredient9 = mealPrep.getString("strIngredient9")
                        val ingredient10 = mealPrep.getString("strIngredient10")
                        val measure1 = mealPrep.getString("strMeasure1")
                        val measure2 = mealPrep.getString("strMeasure2")
                        val measure3 = mealPrep.getString("strMeasure3")
                        val measure4 = mealPrep.getString("strMeasure4")
                        val measure5 = mealPrep.getString("strMeasure5")
                        val measure6 = mealPrep.getString("strMeasure6")
                        val measure7 = mealPrep.getString("strMeasure7")
                        val measure8 = mealPrep.getString("strMeasure8")
                        val measure9 = mealPrep.getString("strMeasure9")
                        val measure10 = mealPrep.getString("strMeasure10")
                        val source = mealPrep.getString("strSource")
                        val imageSource = mealPrep.getString("strImageSource")
                        val creativeCommonsConfirmed = mealPrep.getString("strCreativeCommonsConfirmed")
                        val dateModified = mealPrep.optString("strDateModified","N/A")

                        mTextViewResult.append("1. Id Meal: $idmeal\n,2. Meal Name: $meal\n,3. Drink Alternate: $drinkAlternate\n,3. Category: $category\n,4. Area: $area\n,5. Instructions: $instructions\n,6. Meal Thumb: $mealThumb\n,7. Tags: $tags\n,8. Youtube: $youTube\n,9. Ingredient1: $ingredient1\n,10. Ingredient2: $ingredient2\n,11. Ingredient3: $ingredient3\n,12. Ingredient4: $ingredient4\n,13. Ingredient5: $ingredient5\n,14. Ingredient6: $ingredient6\n,15. Ingredient7: $ingredient7\n,16. Ingredient8: $ingredient8\n,17. Ingredient9: $ingredient9\n,18. Ingredient10: $ingredient10\n,19. Measure1: $measure1\n,20. Measure2: $measure2\n,21. Measure3:$measure3\n,22.Measure4: $measure4\n,23. Measure5: $measure5\n,24. Measure6: $measure6\n,25. Measure7: $measure7\n,26. Measure8:$measure8\n,27. Measure9:$measure9\n,28. Measure10:$measure10\n,29. Source: $source\n,30. Image Source: $imageSource\n,31. Creative Commons Confirmed: $creativeCommonsConfirmed\n,32. Date: $dateModified\n-----------------------------------")

                        InsertDb.setOnClickListener {
                            val helper = MyHelper(applicationContext)
                            val db = helper.writableDatabase
                            val cv = ContentValues()
                            Toast.makeText(applicationContext,"Done !",Toast.LENGTH_LONG).show() //toast notification


                            cv.put("MEAL",meal)
                            cv.put("DRINK_ALTERNATE",drinkAlternate)
                            cv.put("CATEGORY", category)
                            cv.put("AREA",area)
                            cv.put("INSTRUCTIONS",instructions)
                            cv.put("MEAL_THUMB",mealThumb)
                            cv.put("TAGS", tags)
                            cv.put("YOUTUBE", youTube)
                            cv.put("INGREDIENT1",ingredient1)
                            cv.put("INGREDIENT2",ingredient2)
                            cv.put("INGREDIENT3", ingredient3)
                            cv.put("INGREDIENT4", ingredient4)
                            cv.put("INGREDIENT5",ingredient5)
                            cv.put("INGREDIENT6", ingredient6)
                            cv.put("INGREDIENT7", ingredient7)
                            cv.put("INGREDIENT8", ingredient8)
                            cv.put("INGREDIENT9", ingredient9)
                            cv.put("INGREDIENT10", ingredient10)
                            cv.put("MEASURE1",measure1)
                            cv.put("MEASURE2",measure2)
                            cv.put("MEASURE3", measure3)
                            cv.put("MEASURE4",measure4)
                            cv.put("MEASURE5",measure5)
                            cv.put("MEASURE6",measure6)
                            cv.put("MEASURE7", measure7)
                            cv.put("MEASURE8",measure8)
                            cv.put("MEASURE9", measure9)
                            cv.put("MEASURE10", measure10)
                            cv.put("SOURCE", source)
                            cv.put("IMAGE_SOURCE", imageSource)
                            cv.put("CREATIVE_COMMONS_CONFIRMED",creativeCommonsConfirmed)
                            cv.put("DATE_MODIFIED",dateModified)

                            db.insert("MEAL_TABLE", null, cv)
                        }

                        // create a new User object for each meal retrieved from the API
                        val user = User(
                            mealPrep.getInt("idMeal"),
                            mealPrep.getString("strMeal"),
                            mealPrep.getString("strDrinkAlternate"),
                            mealPrep.getString("strCategory"),
                            mealPrep.getString("strArea"),
                            mealPrep.getString("strInstructions"),
                            mealPrep.getString("strMealThumb"),
                            mealPrep.getString("strTags"),
                            mealPrep.getString("strYoutube"),
                            mealPrep.getString("strIngredient1"),
                            mealPrep.getString("strIngredient2"),
                            mealPrep.getString("strIngredient3"),
                            mealPrep.getString("strIngredient4"),
                            mealPrep.getString("strIngredient5"),
                            mealPrep.getString("strIngredient6"),
                            mealPrep.getString("strIngredient7"),
                            mealPrep.getString("strIngredient8"),
                            mealPrep.getString("strIngredient9"),
                            mealPrep.getString("strIngredient10"),
                            mealPrep.getString("strMeasure1"),
                            mealPrep.getString("strMeasure2"),
                            mealPrep.getString("strMeasure3"),
                            mealPrep.getString("strMeasure4"),
                            mealPrep.getString("strMeasure5"),
                            mealPrep.getString("strMeasure6"),
                            mealPrep.getString("strMeasure7"),
                            mealPrep.getString("strMeasure8"),
                            mealPrep.getString("strMeasure9"),
                            mealPrep.getString("strMeasure10"),
                            mealPrep.getString("strSource"),
                            mealPrep.getString("strImageSource"),
                            mealPrep.getString("strCreativeCommonsConfirmed") ,
                            mealPrep.optString("strDateModified")

                        )
                        userList.add(user) // add the User object to the list
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                    mTextViewResult.text = "An error occurred while parsing the JSON response."
                }
            },
            { error ->
                error.printStackTrace()
                mTextViewResult.text = "An error occurred while making the API request."
            }

        )
        mQueue.add(request)

        mTextViewResult.append("\n")

    }


}



















