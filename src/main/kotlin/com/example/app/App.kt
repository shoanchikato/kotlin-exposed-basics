package com.example.app

import com.example.app.repository.PostRepositoryImpl
import com.example.app.db.dao.PostDao
import com.example.app.model.Post


fun main(args: Array<String>) {
    val repo = PostRepositoryImpl()

    val entity = PostDao(userId = 1, title = "post title", body = "post body")
    val updated = Post(id = 1, userId = 1, title = "updated post title", body = "updated post body")

    println("Create: ${repo.create(post = entity)}")
    println("Edit: ${repo.edit(id = 1, post = updated)}")
    println("GetById: ${repo.getById(id = 1)}")
    println("GetAll: ${repo.getAll()}")
}
