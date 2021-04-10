package com.example.app.repository

import com.example.app.db.DBConnection
import com.example.app.db.dao.PostDao
import com.example.app.db.table.Posts
import com.example.app.db.table.toPost
import com.example.app.model.Post
import org.jetbrains.exposed.sql.transactions.transaction
import org.jetbrains.exposed.sql.*

class PostRepositoryImpl : PostRepository {

    val db = DBConnection.db

    override fun create(post: PostDao): Post = transaction {
        val id = Posts.insert {
            it[userId] = post.userId
            it[title] = post.title
            it[body] = post.body

        } get Posts.id

        Posts.select { Posts.id eq id }.single().toPost()
    }

    override fun edit(post: Post, id: Int): Post = transaction {

        Posts.update({Posts.id eq id}) {
            it[userId] = post.userId
            it[title] = post.title
            it[body] = post.body
        }

        Posts.select { Posts.id eq id }.single().toPost()
    }

    override fun getById(id: Int): Post = transaction {
        Posts.select { Posts.id eq id }.single().toPost()
    }

    override fun getAll(): List<Post> = transaction {
        Posts.selectAll().map {
            it.toPost()
        }
    }

}