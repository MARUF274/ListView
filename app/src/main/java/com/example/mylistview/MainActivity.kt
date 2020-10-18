package com.example.mylistview

import android.content.res.TypedArray
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: CardAdapter
    private lateinit var dataName: Array<String>
    private lateinit var dataDescription: Array<String>
    private lateinit var dataPhoto: TypedArray
    private var cards = arrayListOf<Card>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView: ListView = findViewById(R.id.lv_list)
        adapter = CardAdapter(this)
        listView.adapter = adapter

        prepare()
        addItem()
        listView.onItemClickListener = AdapterView.OnItemClickListener{_, _, position,_->
            Toast.makeText(this@MainActivity, cards[position].name, Toast.LENGTH_SHORT).show()
        }
    }
    private fun prepare(){
        dataName = resources.getStringArray(R.array.data_name)
        dataDescription = resources.getStringArray(R.array.data_description)
        dataPhoto = resources.obtainTypedArray(R.array.data_photo)
    }
    private fun addItem(){
        for (position in dataName.indices){
            val card = Card(
                dataPhoto.getResourceId(position, -1),
                dataName[position],
                dataDescription[position]
            )
            cards.add(card)
        }
        adapter.cards = cards
    }
}