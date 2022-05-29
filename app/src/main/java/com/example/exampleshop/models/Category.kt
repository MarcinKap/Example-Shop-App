package com.example.exampleshop.models

import com.example.exampleshop.R

data class Category(
    val id: Long,
    val categoryName: String,
    val categoryIcon: Int
){
    companion object {

        fun getDefaultList(): List<Category> {
            return listOf(
                Category(
                    id = 1,
                    categoryName = "Glasses",
                    categoryIcon = R.drawable.ic_glasses_306695
                ),
                Category(
                    id = 2,
                    categoryName = "Sunglasses",
                    categoryIcon = R.drawable.ic_glasses_306695
                ),
                Category(
                    id = 3,
                    categoryName = "Lenses",
                    categoryIcon = R.drawable.ic_glasses_306695
                ),
                Category(
                    id = 4,
                    categoryName = "Sets",
                    categoryIcon = R.drawable.ic_glasses_306695
                ),
                Category(
                    id = 5,
                    categoryName = "Accessories",
                    categoryIcon = R.drawable.ic_glasses_306695
                ),
                Category(
                    id = 6,
                    categoryName = "Promotions",
                    categoryIcon = R.drawable.ic_glasses_306695
                ),

                )

        }
    }


}
