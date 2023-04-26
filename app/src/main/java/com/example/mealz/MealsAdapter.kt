package com.example.mealz


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.entity.Category


class MealsAdapter( private val categories: ArrayList<Category>) :
    RecyclerView.Adapter<MealsAdapter.CategoryViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.nam.text=categories[position].strCategory
        holder.descripton.text = categories[position].strCategoryDescription
        Glide.with(holder.itemView.context).load(categories[position].strCategoryThumb).into(holder.pic)

    }

    class CategoryViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nam: TextView = itemView.findViewById<TextView>(R.id.nameTxtView)
        val descripton: TextView = itemView.findViewById<TextView>(R.id.desTxtView)
        val pic: ImageView = itemView.findViewById<ImageView>(R.id.picImageView)


    }

}