package gdsc.stydyjams.newsapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import gdsc.stydyjams.newsapp.HeadlineItem
import gdsc.stydyjams.newsapp.R
import gdsc.stydyjams.newsapp.network.Article
import gdsc.stydyjams.newsapp.network.newsApi
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private var _news = MutableLiveData<List<Article>>(listOf())

    val news : MutableLiveData<List<Article>>
        get() = _news

    init {
        getNews()
    }

    private fun getNews()
    {
        viewModelScope.launch {
            try {
                val listResult = newsApi.retrofitService.getNews()
                news.value=listResult.articles
            } catch (e: Exception)
            {
                //display toast
            }
        }
    }
}