package com.example.coinflipper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import org.w3c.dom.Text
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var flipButton: Button
    private lateinit var exitButton: Button
    private lateinit var coinImage: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        exitButton = findViewById(R.id.btn_exit)
        coinImage = findViewById(R.id.img_coin)


            flipCoin()


        exitButton.setOnClickListener {
            finish()
        }
    }

    private fun flipCoin() {
        val ivcoin = findViewById<ImageView>(R.id.img_coin)
        ivcoin.setOnClickListener{
            val result = (1..2).random()
            if (result == 1){
                flipAnimation(R.drawable.head , "HEADS")
            }else{
                flipAnimation(R.drawable.tails, "TAILS")
            }

        }
    }

    private fun flipAnimation(resultImage:Int,resultText: String){
        val imageView = findViewById<ImageView>(R.id.img_coin)
        imageView.animate().apply {
            duration=1000
            rotationBy(1800f)
            imageView.isClickable = false
        }.withEndAction{
            imageView.setImageResource(resultImage)
            Toast.makeText(this,resultText, Toast.LENGTH_SHORT).show()
            imageView.isClickable = true
        }
    }
}
