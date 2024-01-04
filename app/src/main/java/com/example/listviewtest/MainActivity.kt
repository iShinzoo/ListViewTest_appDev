package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var ListOfNames = mutableListOf<String>("krishna","abhay","king","kong","op",
            "solid","magic","trap","school","overpower","scout")

        var namesAdapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,ListOfNames)

        val editText = findViewById<EditText>(R.id.edt)
        val button = findViewById<Button>(R.id.btn)
        var ListView = findViewById<ListView>(R.id.list_View)
        button.setOnClickListener(){
            val name = editText.text.toString()
            ListOfNames.add(name)
            namesAdapter.notifyDataSetInvalidated()
        }
        ListView.adapter = namesAdapter
        ListView.setOnItemClickListener(object : OnItemClickListener{
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
//                pop up message on click
//                val nameClicked = ListOfNames[position]
//                Toast.makeText(this@MainActivity, nameClicked, Toast.LENGTH_SHORT).show()
                ListOfNames.removeAt(position)
                namesAdapter.notifyDataSetInvalidated()
            }
        })
    }
}