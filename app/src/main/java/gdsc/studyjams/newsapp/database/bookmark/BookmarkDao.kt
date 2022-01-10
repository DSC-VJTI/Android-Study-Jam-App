package gdsc.studyjams.newsapp.database.bookmark

import androidx.lifecycle.LiveData
import androidx.room.*

// data access object - the operations to be carried out on the entity
@Dao
interface BookmarkDao {
    @Query("SELECT * FROM bookmark")
    fun getAll(): LiveData<List<Bookmark>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(bookmark: Bookmark)

    @Delete
    suspend fun delete(bookmark: Bookmark)
}