package com.example.fragmentpractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fragmentpractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()
        fragmentTransaction.add(R.id.content, FragmentOne())
        fragmentTransaction.commit()

    }

    override fun onClick(v: View?) {
        var fr : Fragment? = null

        if(v?.id == R.id.button1){
            fr = FragmentOne()
        }
        else if(v?.id == R.id.button2){
            fr = FragmentTwo()
        }
        else if(v?.id == R.id.button3){
            fr = FragmentThree()
        }

        val fm = supportFragmentManager
        val fragmentTransaction = fm.beginTransaction()

        // fragment 교체
        fragmentTransaction.replace(R.id.content, fr!!)
        fragmentTransaction.commit()
    }
}