package nfun.elprogramadorgt.rutineapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import nfun.elprogramadorgt.rutineapp.db.model.Item
import nfun.elprogramadorgt.rutineapp.db.repository.ItemRepository
import java.lang.IllegalArgumentException

class ItemViewModel(private val repository: ItemRepository): ViewModel() {
    val allItems: LiveData<List<Item>> = repository.allItems.asLiveData()

    fun insert(item: Item) = viewModelScope.launch {
        repository.insert(item)
    }

    class ItemViewModelFactory(private val repository: ItemRepository) : ViewModelProvider.Factory {
        override fun <T: ViewModel> create(modelClass: Class<T>): T {
            if(modelClass.isAssignableFrom(ItemViewModel::class.java)){
                @Suppress("UNCHECKED_CAST")
                return ItemViewModel(repository) as T
            }
            throw IllegalArgumentException("Unkown ViewModel Class")
        }
    }
}