package com.example.accountbook

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.accountbook.databinding.ActivityAddBinding

class AddActivity : AppCompatActivity() {

    val b by lazy { ActivityAddBinding.inflate(layoutInflater) }

    private var addType = ""
    private var title = ""
    private var date = ""
    private var price = ""
    private var content = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(b.root)

        // 라디오버튼 선택
        b.radioGroup.setOnCheckedChangeListener { _, checkedId ->
            when(checkedId){
                R.id.income -> {
                    addType = "수입"
                }
                R.id.expense -> {
                    addType = "지출"
                }
            }
        }

        // 작성하기 버튼 클릭시
        b.writeBtn.setOnClickListener {
            // 제목입력
            title = b.wirteTitle.text.toString()

            // 날짜선택
            var month = (b.datePicker.month+1).toString()
            var day = b.datePicker.dayOfMonth.toString()
            if (month.toInt() in 1..9){
                month = "0$month"
            }
            if (day.toInt() in 1..9){
                day = "0$day"
            }
            date = b.datePicker.year.toString() + month + day

            // 금액입력
            price = b.writePrice.text.toString()

            // 내용입력
            content = b.writeContent.text.toString()

            // 작성하기
            addDB()
        }

        b.addToMain.setOnClickListener {
            val addToMain = Intent(this,MainActivity::class.java)
            startActivity(addToMain)
        }
    }

    fun addDB(){
        var dbHelper = DBHelper(this, "account.db", null, 1)

        var database = dbHelper.writableDatabase    //이걸 해야 db가 들어감

        // 공란 체크
        if(addType == ""){
            println("addType : " + addType)
            AlertDialog.Builder(this@AddActivity)
                .setMessage("수입/지출 선택은 필수항목입니다.")
                .setCancelable(false)
                .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, whitch->
                }).show()
        }else if (title == ""){
            AlertDialog.Builder(this@AddActivity)
                .setMessage("제목을 입력해주세요.")
                .setCancelable(false)
                .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, whitch->
                }).show()
        }else if(date == ""){
            AlertDialog.Builder(this@AddActivity)
                .setMessage("날짜를 선택해주세요.")
                .setCancelable(false)
                .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, whitch->
                }).show()
        }else if(price == ""){
            AlertDialog.Builder(this@AddActivity)
                .setMessage("금액을 입력해주세요.")
                .setCancelable(false)
                .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, whitch->
                }).show()
        }else{
            dbHelper.insert(database, addType, title, date.toInt(), price, content)
            AlertDialog.Builder(this@AddActivity)
                .setMessage("등록이 완료되었습니다!")
                .setCancelable(false)
                .setPositiveButton("확인", DialogInterface.OnClickListener{ dialog, whitch->
                    val addToMain = Intent(this,MainActivity::class.java)
                    startActivity(addToMain)
                }).show()
        }
    }

}
