package com.example.accountbook

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accountbook.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {

    val b by lazy { ActivitySearchBinding.inflate(layoutInflater) }

    var selectSpinner = ""
    var accountList = arrayListOf<accountVo>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        setupSpinner()  // 스피너 값 설정
        choiceSpinner() // 스피너 선택 시 효과

        var dbHelper = DBHelper(this, "account.db", null, 1)

        var accountData = dbHelper.writableDatabase

        b.goSearchBtn.setOnClickListener {
            when (selectSpinner) {
                "입/지출" -> {
                    val accountInfo = dbHelper!!.selectType(accountData, b.searchBar.text.toString())
                    accountList = accountInfo as ArrayList<accountVo>
                    val accountAdapter = CustomAdapter(this, accountList)
                    b.recyclerView.adapter = accountAdapter

                    val layout = LinearLayoutManager(this)
                    b.recyclerView.layoutManager = layout

                    b.recyclerView.setHasFixedSize(true)
                }
                "제목" -> {
                    val accountInfo = dbHelper!!.selectTitle(accountData, b.searchBar.text.toString())
                    accountList = accountInfo as ArrayList<accountVo>
                    val accountAdapter = CustomAdapter(this, accountList)
                    b.recyclerView.adapter = accountAdapter

                    val layout = LinearLayoutManager(this)
                    b.recyclerView.layoutManager = layout

                    b.recyclerView.setHasFixedSize(true)
                }
                "내용" -> {
                    val accountInfo = dbHelper!!.selectContent(accountData, b.searchBar.text.toString())
                    accountList = accountInfo as ArrayList<accountVo>
                    val accountAdapter = CustomAdapter(this, accountList)
                    b.recyclerView.adapter = accountAdapter

                    val layout = LinearLayoutManager(this)
                    b.recyclerView.layoutManager = layout

                    b.recyclerView.setHasFixedSize(true)
                }
            }
        }
        b.searchToMain.setOnClickListener {
            val goMain = Intent(this,MainActivity::class.java)
            startActivity(goMain)
        }
    }

    fun setupSpinner(){
        val infoVal = resources.getStringArray(R.array.infoVal)
        val adapter = ArrayAdapter(this, R.layout.item_spinner, infoVal)
        b.spinner.adapter = adapter
    }

    fun choiceSpinner(){
        b.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, v: View?, position: Int, p3: Long) {
                selectSpinner = "${b.spinner.getItemAtPosition(position)}"
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }
        println(selectSpinner)
    }
}

