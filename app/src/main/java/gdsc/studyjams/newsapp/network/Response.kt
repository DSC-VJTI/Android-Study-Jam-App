package gdsc.studyjams.newsapp.network

import com.squareup.moshi.Json
import gdsc.studyjams.newsapp.model.Article

data class Source (@Json(name = "id")  var id: String?,
                   @Json(name = "name") var name: String
                   )

class Response (
    @Json(name = "status") var status: String?,
    @Json(name = "totalResults") var totalResults: Int?,
    @Json(name = "articles") var articles: List<Article>?
)
