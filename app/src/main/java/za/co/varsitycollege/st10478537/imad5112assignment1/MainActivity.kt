package za.co.varsitycollege.st10478537.imad5112assignment1

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Linking XML elements to the code
        val timeInput = findViewById<EditText>(R.id.timeInput)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resetButton = findViewById<Button>(R.id.resetButton)
        val resultText = findViewById<TextView>(R.id.resultText)

        // When the Suggest Meal button is clicked
        suggestButton.setOnClickListener {
            val time = timeInput.text.toString().trim().lowercase() // Convert input to lowercase and trim spaces
            val mealSuggestion = when (time) {
                "morning" -> "Breakfast: Eggs and Toast"
                "mid-morning" -> "Snack: An apple"
                "afternoon" -> "Lunch: Sandwich"
                "mid-after noon" -> "Snack: Cake"
                "dinner" -> "Dinner: Pasta"
                "after dinner" -> "Dessert: Ice cream"
                else -> "Invalid input! Please enter a valid time."
            }
            // Display the meal in the TextView
            resultText.text = mealSuggestion
            // Log the user input and suggested meal in Logcat
            Log.d("MealSuggestion", "User entered: $time, Suggested meal: $mealSuggestion")
            // Error handling: show an error message if the input is invalid
            if (mealSuggestion.contains("Invalid")) {
                timeInput.error = "Please enter a valid time (Morning, Mid-morning, Afternoon, ect."
            }
        }
        // When the Reset button is clicked
        resetButton.setOnClickListener {
            timeInput.text.clear()
            resultText.text = ""
            Log.d("MealSuggestion", "Reset button clicked, fields cleared.")
        }
    }
}