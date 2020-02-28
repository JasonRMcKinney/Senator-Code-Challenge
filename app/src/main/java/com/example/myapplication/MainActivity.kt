package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.network.RetrofitBuilder
import com.example.myapplication.ui.CustomAdapter
import com.example.myapplication.ui.ListingViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager
    var adapter: CustomAdapter? = null
    lateinit var viewModel: ListingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager


        adapter = CustomAdapter(this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this)[ListingViewModel::class.java]

        viewModel.senatorsList.observe(this, Observer {
            adapter?.senators = it
        })
        startRetrieval()


    }

    private fun startRetrieval() {

        val retrofit = RetrofitBuilder().getRetrofit("https://www.govtrack.us/")

        CoroutineScope(Dispatchers.IO).launch {
            val result = retrofit.getSenators("true", "senator").objects
            result.sort()
            withContext(Dispatchers.Main) {
                viewModel.senatorsList.value = result
            }
        }


    }


}
