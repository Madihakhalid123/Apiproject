package com.example.apiproject

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


   var test=findViewById<TextView>(R.id.textview)

        val authorApi = Retrofit_builder.getInstance().create(qutesinterface::class.java)
        val call = authorApi.getData()

        call.enqueue(object : Callback<Author_model> {
            override fun onResponse(call: Call<Author_model>, response: Response<Author_model>) {
                if (response.isSuccessful) {
                    val result = response.body()
                    if (result != null) {

                       // test.text = result.joinToString("\n") // Join the list items into a single string
                        test.text = result[0]
                        Toast.makeText(this@MainActivity, "Success", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this@MainActivity, "Error: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Author_model>, t: Throwable) {
                Log.e("MainActivity", "Failure: ${t.message}")
                Toast.makeText(this@MainActivity, "Network error: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
