package com.example.accountbook

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// Adapter 세팅
class CustomAdapter(private val context: Context, private val accountData: ArrayList<accountVo>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(accountData[position], context)
    }

    override fun getItemCount(): Int {
        return accountData.size
    }

}

class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val type = itemView.findViewById<TextView>(R.id.dateListType)
    private val title = itemView.findViewById<TextView>(R.id.dateListTitle)
    private val date = itemView.findViewById<TextView>(R.id.dateListDate)
    private val price = itemView.findViewById<TextView>(R.id.dateListPrice)

    fun bind(accountVo:accountVo, context: Context){
        type.text = accountVo.type
        title.text = accountVo.title
        date.text = accountVo.date.toString()
        price.text = accountVo.price

        itemView.setOnClickListener {
            // 디테일화면으로 이동, 디테일화면으로 가져갈 데이터 세팅
            Intent(context, AccountDetailActivity::class.java).apply {

                putExtra("account", accountVo)

                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { context.startActivity(this) }
        }
    }
}