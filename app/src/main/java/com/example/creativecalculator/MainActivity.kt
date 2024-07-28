package com.example.creativecalculator

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Setting up array of colors
    private val list = arrayOf("Red", "Yellow", "Blue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Adapters for Spinners
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)
        val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, list)

        val mixBtn = findViewById<Button>(R.id.button)

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Setting Local Variables
        val spinner1 = findViewById<Spinner>(R.id.spinner)
        val spinner2 = findViewById<Spinner>(R.id.spinner2)
        val color1 = findViewById<ImageView>(R.id.color1)
        val color2 = findViewById<ImageView>(R.id.color2)
        val resultColor = findViewById<ImageView>(R.id.resultColor)

        // For Spinner1 Color Selection
        spinner1.adapter = adapter
        spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                if(spinner1.selectedItem.toString() == "Red"){
                    color1.setImageResource(R.drawable.solid_red)
                }
                if(spinner1.selectedItem.toString() == "Yellow"){
                    color1.setImageResource(R.drawable.solid_yellow)
                }
                if(spinner1.selectedItem.toString() == "Blue"){
                    color1.setImageResource(R.drawable.solid_blue)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
        // For Spinner2 Color Selection
        spinner2.adapter = adapter2
        spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: android.view.View?, position: Int, id: Long) {
                if(spinner2.selectedItem.toString() == "Red"){
                    color2.setImageResource(R.drawable.solid_red)
                }
                if(spinner2.selectedItem.toString() == "Yellow"){
                    color2.setImageResource(R.drawable.solid_yellow)
                }
                if(spinner2.selectedItem.toString() == "Blue"){
                    color2.setImageResource(R.drawable.solid_blue)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }

        // For Mixing Colors
        mixBtn.setOnClickListener {
            if(spinner1.selectedItem.toString() == "Red" && spinner2.selectedItem.toString() == "Red"){
                resultColor.setImageResource(R.drawable.solid_red)
            } else if ((spinner1.selectedItem.toString() == "Red" && spinner2.selectedItem.toString() == "Yellow") || (spinner1.selectedItem.toString() == "Yellow" && spinner2.selectedItem.toString() == "Red")){
                resultColor.setImageResource(R.drawable.solid_orange)
            } else if ((spinner1.selectedItem.toString() == "Red" && spinner2.selectedItem.toString() == "Blue") || (spinner1.selectedItem.toString() == "Blue" && spinner2.selectedItem.toString() == "Red")){
                resultColor.setImageResource(R.drawable.solid_purple)
            } else if (spinner1.selectedItem.toString() == "Yellow" && spinner2.selectedItem.toString() == "Yellow"){
                resultColor.setImageResource(R.drawable.solid_yellow)
            } else if ((spinner1.selectedItem.toString() == "Yellow" && spinner2.selectedItem.toString() == "Blue") || (spinner1.selectedItem.toString() == "Blue" && spinner2.selectedItem.toString() == "Yellow")){
                resultColor.setImageResource(R.drawable.solid_green)
            } else if (spinner1.selectedItem.toString() == "Blue" && spinner2.selectedItem.toString() == "Blue"){
                resultColor.setImageResource(R.drawable.solid_blue)
            } else if ((spinner1.selectedItem.toString() == "Blue" && spinner2.selectedItem.toString() == "Yellow") || (spinner1.selectedItem.toString() == "Yellow" && spinner2.selectedItem.toString() == "Blue")){
                resultColor.setImageResource(R.drawable.solid_purple)
            }
        }

    }
}