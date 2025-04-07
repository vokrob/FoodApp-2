package com.vokrob.foodapp_2.Repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.vokrob.foodapp_2.Domain.BannerModel
import com.vokrob.foodapp_2.Domain.CategoryModel

class MainRepository {
    private val firebaseDatabase = FirebaseDatabase.getInstance()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        val listData = MutableLiveData<MutableList<CategoryModel>>()
        val ref = firebaseDatabase.getReference("Category")

        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<CategoryModel>()

                    for (childSnapshot in snapshot.children) {
                        val item = childSnapshot.getValue(CategoryModel::class.java)
                        item?.let { list.add(it) }
                    }

                    listData.value = list
                }

                override fun onCancelled(error: DatabaseError) {}
            }
        )

        return listData
    }

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        val listData = MutableLiveData<MutableList<BannerModel>>()
        val ref = firebaseDatabase.getReference("Banners")

        ref.addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val list = mutableListOf<BannerModel>()

                    for (childSnapshot in snapshot.children) {
                        val item = childSnapshot.getValue(BannerModel::class.java)
                        item?.let { list.add(it) }
                    }

                    listData.value = list
                }

                override fun onCancelled(error: DatabaseError) {}
            }
        )

        return listData
    }
}




















