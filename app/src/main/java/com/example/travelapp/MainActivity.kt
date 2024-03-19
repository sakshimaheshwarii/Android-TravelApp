package com.example.travelapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage=0
    lateinit var image: ImageView

    var places=arrayOf("Red Fort","India Gate","Taj Mahal", "Jama Mashjid", "Dwarka Metro Station","Monuments","Amer Fort")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val next=findViewById<ImageButton>(R.id.btnNext)
        val prev=findViewById<ImageButton>(R.id.btnPrev)
        val placeName=findViewById<TextView>(R.id.nameOfPlace)

        next.setOnClickListener{
//            go to next image
            var idCurrentImageString="img$currentImage"

            var idCurrentimageInt=this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image=findViewById(idCurrentimageInt)
            image.alpha=0f
            currentImage=(7+currentImage+1)%7
            var idImageToShowString="img$currentImage"
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f

            placeName.text=places[currentImage]
        }

        prev.setOnClickListener{
//            go to previous image
            var idCurrentImageString="img$currentImage"

            var idCurrentimageInt=this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            image=findViewById(idCurrentimageInt)
            image.alpha=0f
            currentImage=(7+currentImage-1)%7
            var idImageToShowString="img$currentImage"
            var idImageToShowInt=this.resources.getIdentifier(idImageToShowString, "id", packageName)
            image=findViewById(idImageToShowInt)
            image.alpha=1f
            placeName.text=places[currentImage]
        }
    }
}