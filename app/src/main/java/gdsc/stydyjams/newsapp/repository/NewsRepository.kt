package gdsc.stydyjams.newsapp.repository

import gdsc.stydyjams.newsapp.database.bookmark.Bookmark
import gdsc.stydyjams.newsapp.database.bookmark.BookmarkRoomDatabase
import gdsc.stydyjams.newsapp.model.Article
import gdsc.stydyjams.newsapp.network.NewsApi

class NewsRepository(private val database: BookmarkRoomDatabase) {
    suspend fun getNews() = NewsApi.retrofitService.getNews()

    suspend fun addBookmark(article: Article) =
        database.bookmarkDao().insert(Bookmark(article.title, article.url))

    fun getBookmarks() = database.bookmarkDao().getAll()
}