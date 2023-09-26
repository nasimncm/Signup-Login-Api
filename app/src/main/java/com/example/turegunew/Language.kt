package com.example.turegunew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_language.*

class Language : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_language)

        val language =resources.getStringArray(R.array.language)
        val languageArrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, language)
        autoTvLanguage.setAdapter(languageArrayAdapter)

        val area = resources.getStringArray(R.array.area)
        val areaArrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, area)
        autoTvArea.setAdapter(areaArrayAdapter)

        val currency = resources.getStringArray(R.array.currency)
        val currencyArrayAdapter = ArrayAdapter(this, R.layout.dropdown_item, currency)
        autoTvCurrency.setAdapter(currencyArrayAdapter)

        btnLanguage.setOnClickListener {
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
        }
    }
}