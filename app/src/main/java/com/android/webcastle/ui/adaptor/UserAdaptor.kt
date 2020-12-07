package com.android.webcastle.ui.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.webcastle.data.model.Data
import com.android.webcastle.databinding.UserItemBinding


/**
 * Created by AKSHSAI V SUNIL
 *
 */

/**
 * Recyclerview adapter class for listing FreshProduct
 */
class UserAdaptor() :
    RecyclerView.Adapter<UserAdaptor.MyViewHolder>() {

    var userList: List<Data?>? = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }


    inner class MyViewHolder(var binding: UserItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun setModel(userData: Data) {
            binding.model = userData
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        return MyViewHolder(
            UserItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        userList?.get(position)?.let { holder.setModel(it) }
    }

    override fun getItemCount(): Int = userList!!.size

    interface ItemClick {
        fun onItemSelected(id: String)
    }
}