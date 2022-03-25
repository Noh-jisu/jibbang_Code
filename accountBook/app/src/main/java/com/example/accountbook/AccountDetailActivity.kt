package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accountbook.databinding.ActivityAccountDetailBinding

class AccountDetailActivity : AppCompatActivity() {

    val b by lazy { ActivityAccountDetailBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        // 받아온 데이터
        val accountDetail = intent.getParcelableExtra<accountVo>("account")

        // 각 View에 데이터 세팅
        b.typeDetail.text = accountDetail?.type
        b.tilteDetail.text = accountDetail?.title
        b.dateDetail.text = accountDetail?.date.toString()
        b.priceDetail.text = accountDetail?.price
        b.contentDetail.text = accountDetail?.content

    }
}