package gdsc.stydyjams.newsapp.model

import com.squareup.moshi.Json
import gdsc.stydyjams.newsapp.network.Source
import java.io.Serializable

// Article implements Serializable interface in order to be passed as argument in Bundle while using navArgs
data class Article (
    @Json(name = "source") var source: Source,
    @Json(name = "author") var author: String,
    @Json(name = "title") var title: String,
    @Json(name = "description") var description: String,
    @Json(name = "url") var url: String,
    @Json(name = "urlToImage") var urlToImage: String,
    @Json(name = "publishedAt") var publishedAt: String,
    @Json(name = "content") var content: String,
) : Serializable