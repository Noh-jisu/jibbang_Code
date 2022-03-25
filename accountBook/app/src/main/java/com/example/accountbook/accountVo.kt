package com.example.accountbook

import android.os.Parcel
import android.os.Parcelable


// 데이터를 포장해서 가져간다는의미인 Parcel 을 사용하여 데이터 전송
class accountVo(val type:String?, val title:String?, val date:Int, val price:String?, val content:String?) : Parcelable {
    constructor(p:Parcel) : this(p.readString(), p.readString(), p.readInt(), p.readString(), p.readString()){}

    override fun writeToParcel(p: Parcel?, p1: Int) {
        p?.writeString(type)
        p?.writeString(title)
        p?.writeInt(date)
        p?.writeString(price)
        p?.writeString(content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<accountVo> {
        override fun createFromParcel(parcel: Parcel): accountVo {
            return accountVo(parcel)
        }

        override fun newArray(size: Int): Array<accountVo?> {
            return arrayOfNulls(size)
        }
    }
}