package com.example.summerpractice2025.homework_2.data

object DataGenerator {
    private val titles = listOf("Заголовок 1", "Заголовок 2", "Заголовок 3")
    private val descriptions = listOf("Описание 1", "Описание 2", "Описание 3")
    val imageUrls = listOf(
        "https://i.pinimg.com/736x/ca/1b/16/ca1b1635bd93ad25d0c430c67e459fa3.jpg",
        "https://i.pinimg.com/736x/27/3d/b4/273db40845c970d2777bab0cef4e4cd6.jpg",
        "https://i.pinimg.com/736x/7c/14/c8/7c14c8596bb124afd094a5a4a9b4247b.jpg"
    )

    fun generateData(count: Int): List<DataModel> {
        return (1..count).map {
            DataModel(
                id = it,
                title = titles.random(),
                description = descriptions.random(),
                imageUrl = imageUrls.random()
            )
        }
    }
}