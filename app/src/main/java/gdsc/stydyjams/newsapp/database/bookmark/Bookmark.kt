package gdsc.stydyjams.newsapp.database.bookmark

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// representation of the bookmark table as Entity in the Room database
@Entity
data class Bookmark(
    @PrimaryKey @NonNull @ColumnInfo(name = "title") val headline: String,
    @NonNull @ColumnInfo(name = "url") val url: String
)