package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.recyclerview.databinding.ActivityUserDetailBinding

class UserDetailActivity : AppCompatActivity() {

    val b by lazy { ActivityUserDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        // CustomAdapter 에서 가져온 데이터 세팅
        val data = intent.getParcelableExtra<UserDataVo>("data")

        // imageView에 이미지 세팅
        Glide.with(this).load(getImage(data?.photo)).into(b.imageView)

        // 각 View에 문구 세팅
        b.userNameDetail.text = "이름 : " + data?.name
        b.userDepartDetail.text = "지원분야 : " + data?.department
        b.userAddressDetail.text = "주소 : " + data?.address
        b.userPhoneDetail.text = "연락처 : " + data?.phoneNum
        b.wishPayDetail.text = "희망연봉 : " + data?.wishPay
    }

    // drawable폴더에 있는 이미지를 불러오는 함수
    fun getImage(imageName:String?) : Int{
        return resources.getIdentifier(imageName, "drawable", packageName)
    }
}

