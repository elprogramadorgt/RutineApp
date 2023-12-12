package nfun.elprogramadorgt.rutineapp.db.repository

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow
import nfun.elprogramadorgt.rutineapp.db.dao.ItemDao
import nfun.elprogramadorgt.rutineapp.db.model.Item


class ItemRepository(private val itemDao: ItemDao) {

    val allItems: Flow<List<Item>> = itemDao.getAllItems()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(item: Item) {
        itemDao.insert(item)
    }
}