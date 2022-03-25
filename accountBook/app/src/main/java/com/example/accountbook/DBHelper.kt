package com.example.accountbook

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context?, name:String?, factory: SQLiteDatabase.CursorFactory?, version: Int) : SQLiteOpenHelper(context, name, factory, version) {
    override fun onCreate(db: SQLiteDatabase?) {
        var sql : String = "CREATE TABLE IF NOT EXISTS ACCOUNTBOOK(" +
                "TYPE TEXT," +
                "TITLE TEXT," +
                "DATE INTEGER," +
                "PRICE TEXT," +
                "CONTENT TEXT)"

        db?.execSQL(sql)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        var sql : String = "DROP TABLE IF EXISTS ACCOUNTBOOK"
        db?.execSQL(sql)
        onCreate(db)
    }

    fun insert(db:SQLiteDatabase, type:String, title:String, date:Int, price:String, content:String){
        var sql = "INSERT INTO ACCOUNTBOOK(TYPE, TITLE, DATE, PRICE, CONTENT)" +
                "VALUES('${type}', '${title}', '${date}', '${price}', '${content}')"

        db.execSQL(sql)
    }

    @SuppressLint("Range")
    fun selectType(db:SQLiteDatabase, type:String) : MutableList<accountVo>?{
        var sql = "SELECT * FROM ACCOUNTBOOK WHERE TYPE LIKE '%${type}%'"

        var result = db.rawQuery(sql, null)

        var account:accountVo? = null
        var accountList:MutableList<accountVo> = mutableListOf<accountVo>()
        while (result.moveToNext()){
            account = accountVo(
                result.getString(result.getColumnIndex("TYPE")),
                result.getString(result.getColumnIndex("TITLE")),
                result.getInt(result.getColumnIndex("DATE")),
                result.getString(result.getColumnIndex("PRICE")),
                result.getString(result.getColumnIndex("CONTENT")))
            accountList.add(account)
        }
        return  accountList
    }

    @SuppressLint("Range")
    fun selectTitle(db:SQLiteDatabase, title:String) : MutableList<accountVo>{
        var sql = "SELECT * FROM ACCOUNTBOOK WHERE TITLE LIKE '%${title}%'"

        var result = db.rawQuery(sql, null)

        var account:accountVo? = null
        var accountList:MutableList<accountVo> = mutableListOf<accountVo>()
        while (result.moveToNext()){
            account = accountVo(
                result.getString(result.getColumnIndex("TYPE")),
                result.getString(result.getColumnIndex("TITLE")),
                result.getInt(result.getColumnIndex("DATE")),
                result.getString(result.getColumnIndex("PRICE")),
                result.getString(result.getColumnIndex("CONTENT")))
            accountList.add(account)
        }
        return  accountList
    }

    @SuppressLint("Range")
    fun selectContent(db:SQLiteDatabase, content:String) : MutableList<accountVo>?{
        var sql = "SELECT * FROM ACCOUNTBOOK WHERE CONTENT LIKE '%${content}%'"

        var result = db.rawQuery(sql, null)

        var account:accountVo? = null
        var accountList:MutableList<accountVo> = mutableListOf<accountVo>()
        while (result.moveToNext()){
            account = accountVo(
                result.getString(result.getColumnIndex("TYPE")),
                result.getString(result.getColumnIndex("TITLE")),
                result.getInt(result.getColumnIndex("DATE")),
                result.getString(result.getColumnIndex("PRICE")),
                result.getString(result.getColumnIndex("CONTENT")))
            accountList.add(account)
        }
        return  accountList
    }

    @SuppressLint("Range")
    fun selectDate(db:SQLiteDatabase, startDate: Int, endDate: Int) : MutableList<accountVo> {
        var sql = "SELECT * FROM ACCOUNTBOOK WHERE '${startDate}' <= DATE AND DATE <= '${endDate}'"

        var result = db.rawQuery(sql, null)

        var account: accountVo? = null
        var accountList: MutableList<accountVo> = mutableListOf<accountVo>()
        while (result.moveToNext()) {
            account = accountVo(
                result.getString(result.getColumnIndex("TYPE")),
                result.getString(result.getColumnIndex("TITLE")),
                result.getInt(result.getColumnIndex("DATE")),
                result.getString(result.getColumnIndex("PRICE")),
                result.getString(result.getColumnIndex("CONTENT"))
            )
            accountList.add(account)
        }
        return accountList
    }
}
























