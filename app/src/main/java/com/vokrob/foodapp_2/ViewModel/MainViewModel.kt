package com.vokrob.foodapp_2.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.vokrob.foodapp_2.Domain.BannerModel
import com.vokrob.foodapp_2.Domain.CategoryModel
import com.vokrob.foodapp_2.Domain.FoodModel
import com.vokrob.foodapp_2.Repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadFiltered(id: String): LiveData<MutableList<FoodModel>> {
        return repository.loadFiltered(id)
    }
}





















