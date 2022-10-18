package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recicleView)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ItemsViewModel
        val data = ArrayList<ItemsViewModel>()

        // ArrayList of class ItemsViewModel
        val list1 = listOf ("Xavier",
            "Joao",
            "Samuel",
            "Vitor",
            "Pedro" )

        val list2 = listOf(
            "Maria",
            "Ana",
            "Isabel",
            "Rita",
            "Catarina" )

        val listaCompleta: MutableList<String> = ArrayList()

        for (item in list1) {
            listaCompleta.add(item)
        }
        for (item in list2) {
            listaCompleta.add(item)
        }

        listaCompleta.sort()

        for (item in listaCompleta)
        {
            data.add(ItemsViewModel(item))
        }

        // This will pass the ArrayList to our Adapter
        val adapter = CustomAdapter(data)

        // Setting the Adapter with the recyclerview
        recyclerview.adapter = adapter
    }
}