package com.freeankit.rxjava2samples.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.ui.operators.MapOperatorActivity
import com.freeankit.rxjava2samples.ui.operators.SimpleOperatorActivity
import com.freeankit.rxjava2samples.ui.operators.ZipOperatorActivity

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 08/12/2017 (MM/DD/YYYY )
 */
class OperatorsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_operators)
    }

    fun startSimpleActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, SimpleOperatorActivity::class.java))
    }

    fun startMapActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, MapOperatorActivity::class.java))
    }

    fun startZipActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, ZipOperatorActivity::class.java))
    }
}