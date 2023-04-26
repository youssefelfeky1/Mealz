package com.example.domain.repo

import com.example.domain.entity.CategoryResponse

 interface MealsRepo{
    suspend fun getMealsFromRemote():CategoryResponse
}