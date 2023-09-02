package com.dicoding.androidbeginnerfp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val SHOE_DATA = "shoe_data"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvName: TextView = findViewById(R.id.tv_product_name)
        val tvDesc: TextView = findViewById(R.id.tv_product_desc)
        val tvCat: TextView = findViewById(R.id.tv_product_category)
        val tvPrice: TextView = findViewById(R.id.tv_product_price)
        val imgShoe: ImageView = findViewById(R.id.img_product_photo)
        val imgDetail1: ImageView = findViewById(R.id.img_product_detail)
        val imgDetail2: ImageView = findViewById(R.id.img_product_detail2)

        val btnShare: Button = findViewById(R.id.action_share)
        btnShare.setOnClickListener(this)

        val shoe = if (Build.VERSION.SDK_INT > 33) {
            intent.getParcelableExtra<Shoe>(SHOE_DATA, Shoe::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Shoe>(SHOE_DATA)
        }

        if (shoe != null) {
            tvName.text = shoe.name
            tvDesc.text = shoe.desc
            tvCat.text = shoe.category
            tvPrice.text = shoe.price
            imgShoe.setImageResource(shoe.photo)
            imgDetail1.setImageResource(shoe.photo2)
            imgDetail2.setImageResource(shoe.photo3)
        }
    }

    override fun onClick(v: View?) {
        val shoe = if (Build.VERSION.SDK_INT > 33) {
            intent.getParcelableExtra<Shoe>(SHOE_DATA, Shoe::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Shoe>(SHOE_DATA)
        }

        when (v?.id) {
            R.id.action_share -> {
                val share = Intent(Intent.ACTION_SEND)
                share.type = "text/plain"
                share.putExtra(Intent.EXTRA_TEXT, "Dapatkan ${shoe?.name} terbaik hanya di www.adidas.co.id")
                startActivity(Intent.createChooser(share, "Share Link"))
            }
        }
    }
}