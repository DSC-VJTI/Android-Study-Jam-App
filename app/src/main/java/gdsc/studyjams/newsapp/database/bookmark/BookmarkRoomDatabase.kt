package gdsc.studyjams.newsapp.database.bookmark

import android.content.Context
import androidx.room.*
import gdsc.studyjams.newsapp.network.Source

// creating an instance of the Room database that will contain the Bookmark entity
@Database(entities = [Bookmark::class], version = 2, exportSchema = false)
@TypeConverters(Converters::class)
abstract class BookmarkRoomDatabase : RoomDatabase() {

    abstract fun bookmarkDao(): BookmarkDao

    companion object {
        @Volatile
        private var INSTANCE: BookmarkRoomDatabase? = null

        fun getDatabase(context: Context): BookmarkRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BookmarkRoomDatabase::class.java,
                    "bookmark_database.db"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }


    }
}


class Converters {

    @TypeConverter
    fun fromSource(source: Source): String {
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }

}