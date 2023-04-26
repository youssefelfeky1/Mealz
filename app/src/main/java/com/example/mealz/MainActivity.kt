package com.example.mealz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.HorizontalScrollView
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import dagger.hilt.android.AndroidEntryPoint

import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val viewModel:MealsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val rv:RecyclerView = findViewById<RecyclerView>(R.id.catRV)
        rv.layoutManager=LinearLayoutManager(this)


        lifecycleScope.launch {
            viewModel.getMeals()
            viewModel.categories.collect{
                val mealsAdapter= it?.categories?.let { it1 -> MealsAdapter(it1) }
                rv.adapter= mealsAdapter

            }

            }
        }
    }
