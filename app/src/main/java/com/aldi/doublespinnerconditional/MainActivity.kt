package com.aldi.doublespinnerconditional

import android.app.PendingIntent.getActivity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import android.widget.*
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.ToolbarWidgetWrapper
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var category1: String? = null
    var category2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chooseCategorySpinner1()

        showText()
    }


    private fun chooseCategorySpinner1() {
        layout1.setOnClickListener {
            if (layout1.isVisible) {
                layout1.visibility = View.INVISIBLE
                val categoryArray = ArrayAdapter(
                    this,
                    android.R.layout.simple_spinner_dropdown_item,
                    resources.getStringArray(R.array.category_primary)
                )
                spinner1.adapter = categoryArray
                spinner1.performClick()
                chooseCategorySpinner2()
                spinner1.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(p0: AdapterView<*>?) {

                    }

                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        category1 = categoryArray?.getItem(p2).toString()
                        when (p2) {
                            0 -> {
                                val category2Array = ArrayAdapter(
                                    this@MainActivity,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    resources.getStringArray(R.array.category_flowers)
                                )
                                spinner2.adapter = category2Array

                            }
                            1 -> {
                                val category2Array = ArrayAdapter(
                                    this@MainActivity,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    resources.getStringArray(R.array.category_fruits)
                                )
                                spinner2.adapter = category2Array
                            }
                            2 -> {
                                val category2Array = ArrayAdapter(
                                    this@MainActivity,
                                    android.R.layout.simple_spinner_dropdown_item,
                                    resources.getStringArray(R.array.category_vegetables)
                                )
                                spinner2.adapter = category2Array
                            }
                        }
                    }
                }
                spinner1.visibility = View.VISIBLE
            } else {
                layout1.visibility = View.VISIBLE
            }
        }
    }

    private fun chooseCategorySpinner2() {
        layout2.visibility = View.VISIBLE
        layout2.setOnClickListener {
            if (layout2.isVisible) {
                layout2.visibility = View.INVISIBLE
                spinner2.performClick()
                spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(p0: AdapterView<*>?) {
                    }

                    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                        category2 = spinner2.getItemAtPosition(p2).toString()
                    }
                }
            }
        }
    }

    private fun showText() {
        btn.setOnClickListener {
            if (category1 == null && category2 == null) {
                Toast.makeText(this,"Mohon Pilih Terlebih Dahulu!",Toast.LENGTH_LONG)
            } else {
                tv1.text = category1.toString()
                tv2.text = category2.toString()
            }
        }
    }
}