package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.model.Senator
import com.example.myapplication.network.RetrofitBuilder
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    var senators: List<Senator> = emptyList()
    private lateinit var linearLayoutManager: LinearLayoutManager
    var adapter: CustomAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager as RecyclerView.LayoutManager?


        adapter = CustomAdapter(this)
        recyclerView.adapter = adapter
        startRetrieval()


    }

    private fun startRetrieval() {

        val retrofit = RetrofitBuilder().getRetrofit("https://www.govtrack.us/")

        CoroutineScope(Dispatchers.IO).launch {
            var result = retrofit.getSenators("true", "senator").objects
            var x = result
            withContext(Dispatchers.Main){
                adapter?.senators = x
            }
       }


    }

}
