package com.example.app.repository

import com.example.app.db.dao.PostDao
import com.example.app.model.Post

interface PostRepository {
    fun create(post: PostDao): Post
    fun edit(post: Post, id: Int): Post
    fun getById(id: Int): Post
    fun getAll(): List<Post>
}