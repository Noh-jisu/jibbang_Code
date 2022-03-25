package com.example.recyclerview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CustomAdapter(private val context:Context, private val userData: ArrayList<UserDataVo>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(userData[position], context)
    }

    override fun getItemCount(): Int {
        return userData.size
    }
}

class ItemViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
    private val userName = itemView.findViewById<TextView>(R.id.userName)
    private val supDepartment = itemView.findViewById<TextView>(R.id.supDepartment)
    private val userAddress = itemView.findViewById<TextView>(R.id.userAddress)
    private val wishPay = itemView.findViewById<TextView>(R.id.userWishPay)
    private val userPhoto = itemView.findViewById<ImageView>(R.id.userPhoto)
    private val userPhoneNum = itemView.findViewById<TextView>(R.id.userPhoneNum)

    // data -> resource(binding)
    fun bind(userVo:UserDataVo, context: Context){
        // 사진
        if (userVo.photo != ""){    // 이미지가 제대로 들어왔을 때
            val resId =context.resources.getIdentifier(userVo.photo, "drawable", context.packageName)

            if(resId > 0){
                userPhoto.setImageResource(resId)
            }else{
                Glide.with(itemView).load(userVo.photo).into(userPhoto)
            }
        }else{  // 이미지가 없을 때
            userPhoto.setImageResource(R.mipmap.ic_launcher_round)  // 이미지없음. 아무 이미지노출
        }

        //TextView 데이터 세팅
        userName.text = "이름 : " + userVo.name
        supDepartment.text = "지원분야 : " + userVo.department
        userAddress.text = "주소 : " + userVo.address
        wishPay.text = "희망연봉 : " + userVo.wishPay
        userPhoneNum.text = "연락처 : " + userVo.phoneNum
    // ------------------------------------------------------------------
        // itemView 클릭 시 이벤트
        itemView.setOnClickListener{
            // 화면 UserDetailActivity로 이동
            Intent(context, UserDetailActivity::class.java).apply {

                // UserDetailActivity로 가져갈 데이터
                putExtra("data", userVo)

                // 새로운 task를 생성해서 새로운 activity를 추가(덮어쓰기)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.run { context.startActivity(this) }
        }
    }

}