package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val b by lazy { ActivityMainBinding.inflate(layoutInflater) }

    var userList = arrayListOf<UserDataVo>(
        UserDataVo("김철수", "인사관리팀", "서울시", "30000000", "kim", "010-1234-5678"),
        UserDataVo("박상현", "총무팀", "부산시", "50000000", "park", "010-4532-5348"),
        UserDataVo("최진형", "인사관리팀", "광주시", "40000000", "choi", "010-8755-4537"),
        UserDataVo("정수동", "회계팀", "충주시", "45000000", "jung", "010-2453-7787")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        val userAdapter = CustomAdapter(this, userList)
        b.recyclerView.adapter = userAdapter

        val layout = LinearLayoutManager(this)
        b.recyclerView.layoutManager = layout

        b.recyclerView.setHasFixedSize(true)
    }
}