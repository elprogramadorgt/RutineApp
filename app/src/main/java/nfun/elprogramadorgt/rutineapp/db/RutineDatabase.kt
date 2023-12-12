package nfun.elprogramadorgt.rutineapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import nfun.elprogramadorgt.rutineapp.db.dao.ItemDao
import nfun.elprogramadorgt.rutineapp.db.model.Item

@Database(entities = [Item::class], version = 1)
abstract class RutineDatabase:RoomDatabase() {
    abstract fun itemDao(): ItemDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: RutineDatabase? = null

        fun getDatabase(context: Context): RutineDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RutineDatabase::class.java,
                    "runtime_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}