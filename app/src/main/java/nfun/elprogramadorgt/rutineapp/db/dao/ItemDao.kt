package nfun.elprogramadorgt.rutineapp.db.dao


import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import nfun.elprogramadorgt.rutineapp.db.model.Item

import kotlinx.coroutines.flow.Flow


@Dao
interface ItemDao {
    @Query("SELECT id, name, active FROM item")
    fun getAllItems(): Flow<List<Item>>

    //    REMOVE vararg TO SEE WHAT HAPPENS
    @Update
    fun update(vararg item:Item)

    @Insert
    fun insert(item:Item)

    @Delete
    fun delete(item:Item)

}