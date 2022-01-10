package gdsc.studyjams.newsapp.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gdsc.studyjams.newsapp.model.Article
import gdsc.studyjams.newsapp.network.Response
import gdsc.studyjams.newsapp.repository.NewsRepository
import kotlinx.coroutines.launch

class ListViewModel(private val repository: NewsRepository) : ViewModel() {

    private var _news = MutableLiveData<List<Article>>(listOf())

    val news: MutableLiveData<List<Article>>
        get() = _news

    init {
        getNews()
    }

    private fun getNews() {
        viewModelScope.launch {
            try {
                val listResult: Response = repository.getNews()
                news.value = listResult.articles
            } catch (e: Exception) {
                Log.e("List Fragment", "Error in fetching news articles $e")
            }
        }
    }

    fun getBookmarks() = repository.getBookmarks()

    fun addBookmark(article: Article?) = viewModelScope.launch {
        repository.addBookmark(article)
    }


}