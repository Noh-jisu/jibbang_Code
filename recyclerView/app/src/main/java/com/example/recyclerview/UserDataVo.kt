package com.example.recyclerview

import android.os.Parcel
import android.os.Parcelable

// parcel은 꾸러미라는 뜻으로 데이터를 보낼때 포장해주는 방법으로 해석 가능
// 가져가고, 받아올 데이터를 포장해주고 세팅하는 과정
class UserDataVo(val name:String?, val department:String?, val address:String?, val wishPay:String?, val photo:String?, val phoneNum:String?) : Parcelable {

    constructor(p:Parcel) : this(
        p.readString(), p.readString(), p.readString(), p.readString(), p.readString(), p.readString()  // UserDataVo의 매개변수들
    ){}

    override fun writeToParcel(p: Parcel, p1: Int) {
        p.writeString(name)
        p.writeString(department)
        p.writeString(address)
        p.writeString(wishPay)
        p.writeString(photo)
        p.writeString(phoneNum)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserDataVo> {
        override fun createFromParcel(parcel: Parcel): UserDataVo {
            return UserDataVo(parcel)
        }

        override fun newArray(size: Int): Array<UserDataVo?> {
            return arrayOfNulls(size)
        }
    }
}