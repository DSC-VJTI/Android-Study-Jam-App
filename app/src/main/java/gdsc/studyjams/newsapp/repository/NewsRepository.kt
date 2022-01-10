package gdsc.studyjams.newsapp.repository

import gdsc.studyjams.newsapp.database.bookmark.Bookmark
import gdsc.studyjams.newsapp.database.bookmark.BookmarkRoomDatabase
import gdsc.studyjams.newsapp.model.Article
import gdsc.studyjams.newsapp.network.NewsApi

class NewsRepository(private val database: BookmarkRoomDatabase) {
    suspend fun getNews() = NewsApi.retrofitService.getNews()

    suspend fun addBookmark(article: Article?) =
        article?.let { Bookmark(it.title, article.url) }?.let { database.bookmarkDao().insert(it) }

    fun getBookmarks() = database.bookmarkDao().getAll()
}