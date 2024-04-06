package com.example.androidlab2

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.androidlab2.databinding.RecyclerItemBinding
import com.example.androidlab2.model.Cat

class AdapterClass() :
    RecyclerView.Adapter<AdapterClass.ViewHolder>() {
    private val items: ArrayList<Cat> = arrayListOf()

    fun setCats(catsList: List<Cat>) {
        val diffResult = DiffUtil.calculateDiff(CatDiffCallBack(items, catsList))
        items.clear()
        items.addAll(catsList)
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterClass.ViewHolder {
        return ViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdapterClass.ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val binding: RecyclerItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun bind(cat: Cat) {
            with(binding) {

                Glide
                    .with(root.context)
                    .load(cat.imageLink)
                    .into(image)

                name.text = cat.name
                origin.text = cat.origin
                length.text = cat.length
                minWeight.text = "${cat.minWeight.toString()}kg"
                maxWeight.text = "${cat.maxWeight.toString()}kg"
                ff.text = cat.familyFriendly.toString()
                cf.text = cat.childrenFriendly.toString()
            }
        }

    }

    class CatDiffCallBack(
        private val oldList: List<Cat>,
        private val newList: List<Cat>
    ) : DiffUtil.Callback() {
        override fun getOldListSize(): Int = oldList.size

        override fun getNewListSize(): Int = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition].name == newList[newItemPosition].name
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}