package com.freeankit.rxkotlinoperators.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.freeankit.rxkotlinoperators.ui.RxPagination.PaginationActivity
import com.freeankit.rxkotlinoperators.R
import com.freeankit.rxkotlinoperators.ui.RxBinding.RxLoginScreenActivity

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 08/12/2017 (MM/DD/YYYY )
 */
class SelectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_selection)
    }

    fun startOperatorsActivity(view: View) {
        startActivity(Intent(this@SelectionActivity, OperatorsActivity::class.java))
    }

    fun startRxBinding(view: View) {
        startActivity(Intent(this@SelectionActivity, RxLoginScreenActivity::class.java))
    }

    fun startRxPagination(view: View) {
        startActivity(Intent(this@SelectionActivity, PaginationActivity::class.java))
    }
}