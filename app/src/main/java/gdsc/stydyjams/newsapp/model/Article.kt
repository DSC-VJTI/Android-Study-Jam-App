package gdsc.stydyjams.newsapp.model

import com.squareup.moshi.Json
import java.io.Serializable

// Article implements Serializable interface in order to be passed as argument in Bundle while using navArgs
data class Article (
    @Json(name = "title") var title: String,
    @Json(name = "url") var url: String,
) : Serializable