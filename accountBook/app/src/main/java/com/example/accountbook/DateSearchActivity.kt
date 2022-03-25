package com.example.accountbook

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.accountbook.databinding.ActivityDateSearchBinding

class DateSearchActivity : AppCompatActivity() {

    val b by lazy { ActivityDateSearchBinding.inflate(layoutInflater) }

    private var accountList = arrayListOf<accountVo>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        // 시작날짜선택
        var startDate = ""

        b.starDate.setOnDateChangedListener { datePicker, year, month, date ->
            startDate = choiceDate(year, (month+1), date)
        }

        // 종료날짜선택
        var endDate = ""
        b.endDate.setOnDateChangedListener { datePicker, year, month, date ->
            endDate = choiceDate(year, (month+1), date)
        }

        // 조회하기 버튼 클릭시
        b.dateBetweenBtn.setOnClickListener {

            var dbHelper = DBHelper(this, "account.db", null, 1)
            var accountData = dbHelper.writableDatabase

            val accountInfo = dbHelper!!.selectDate(accountData, startDate.toInt(), endDate.toInt())
            accountList = accountInfo as ArrayList<accountVo>
            println("startDate : $startDate")
            println("endDate : $endDate")

            val accountAdapter = CustomAdapter(this, accountList)
            b.dateRecycler.adapter = accountAdapter

            val layout = LinearLayoutManager(this)
            b.dateRecycler.layoutManager = layout

            b.dateRecycler.setHasFixedSize(true)

            var totalIncom:Int = 0
            var totalExpense:Int = 0

            for(i in accountList.indices) {
                if (accountList[i].type == "지출") {
                    totalExpense += accountList[i].price!!.toInt()
                } else {
                    totalIncom += accountList[i].price!!.toInt()
                }
            }
            b.totalIncom.text = totalIncom.toString()
            b.totalExpense.text = totalExpense.toString()
            b.totalPrice.text = (totalIncom - totalExpense).toString()
        }

        b.dateToMain.setOnClickListener {
            val goMain = Intent(this,MainActivity::class.java)
            startActivity(goMain)
        }
    }

    // 날짜선택 함수
    private fun choiceDate(year:Int, month:Int, day:Int) : String{
        var Month = (month).toString()
        var Day = day.toString()
        if (Month.toInt() in 1..9){
            Month = "0$Month"
        }
        if (Day.toInt() in 1..9){
            Day = "0$Day"
        }
        return year.toString() + Month + Day

    }
}
