package nfun.elprogramadorgt.rutineapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

import androidx.recyclerview.widget.RecyclerView
import nfun.elprogramadorgt.rutineapp.db.model.Item

class ItemListAdapter : ListAdapter<Item, ItemListAdapter.ItemViewHolder>(ItemsComparator()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.name)
    }


    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemItemView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String?) {
            itemItemView.text = text
        }

        companion object {
            fun create(parent: ViewGroup): ItemViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R.layout.recyclerview_item, parent, false)
                return ItemViewHolder(view)
            }
        }
    }

    class ItemsComparator: DiffUtil.ItemCallback<Item>(){
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.name == newItem.name
        }
    }

}


