package com.dicoding.androidbeginnerfp

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvShoes: RecyclerView
    private val list = ArrayList<Shoe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvShoes = findViewById(R.id.rv_shoes)
        rvShoes.setHasFixedSize(true)

        list.addAll(getListShoes())
        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_grid -> {
                rvShoes.layoutManager = GridLayoutManager(this, 2)
            }

            R.id.action_list -> {
                rvShoes.layoutManager = LinearLayoutManager(this)
            }

            R.id.action_about -> {
                val aboutIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(aboutIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun getListShoes(): ArrayList<Shoe> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDesc = resources.getStringArray(R.array.data_desc)
        val dataCat = resources.getStringArray(R.array.data_category)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val detail1 = resources.obtainTypedArray(R.array.data_detail1)
        val detail2 = resources.obtainTypedArray(R.array.data_detail2)
        val listShoe = ArrayList<Shoe>()
        for (i in dataName.indices) {
            val shoe = Shoe(dataName[i], dataDesc[i], dataCat[i], dataPrice[i], dataPhoto.getResourceId(i, -1), detail1.getResourceId(i, -1), detail2.getResourceId(i, -1))
            listShoe.add(shoe)
        }
        return listShoe
    }

    private fun showRecyclerList() {
        rvShoes.layoutManager = GridLayoutManager(this, 2)
        val listShoeAdapter = ListShoeAdapter(list)
        rvShoes.adapter = listShoeAdapter
    }
}