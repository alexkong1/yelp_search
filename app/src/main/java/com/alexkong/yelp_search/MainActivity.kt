package com.alexkong.yelp_search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import com.alexkong.yelp_search.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        initializeUi(binding)
    }

    private fun initializeUi(binding: ActivityMainBinding) {
        findViewById<EditText>(R.id.et_search_bar).addTextChangedListener(
            object: TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                    //TODO("Not yet implemented")
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    //TODO("Not yet implemented")
                }

                override fun afterTextChanged(s: Editable?) {
                    //TODO("Not yet implemented")
                }
            }
        )
    }
}