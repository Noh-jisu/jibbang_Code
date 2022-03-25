package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.accountbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        //가계부 작성 버튼 클릭시 이벤트
        b.addBtn.setOnClickListener {
            val mainToAdd = Intent(this,AddActivity::class.java)
            // AddActivity 로 이동
            startActivity(mainToAdd)
        }

        // 내역조회 버튼 클릭시 이벤트
        b.searchBtn.setOnClickListener {
            val mainToSearch = Intent(this,SearchActivity::class.java)
            // SearchActivity 로 이동
            startActivity(mainToSearch)
        }

        // 기간검색 버튼 클릭시 이벤트
        b.dateSearchBtn.setOnClickListener {
            val mainToDateSearch = Intent(this,DateSearchActivity::class.java)
            // DateSearchActivity 로 이동
            startActivity(mainToDateSearch)
        }

    }
}