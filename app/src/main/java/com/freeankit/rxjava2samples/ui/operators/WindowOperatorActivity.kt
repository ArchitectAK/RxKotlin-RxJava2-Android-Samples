package com.freeankit.rxjava2samples.ui.operators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeankit.rxjava2samples.R
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 19/02/2018 (MM/DD/YYYY )
 */
class WindowOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeWindowOperator() })
    }


    /*
    * Example using window operator -> It periodically
    * subdivide items from an Observable into
    * Observable windows and emit these windows rather than
    * emitting the items one at a time
    */

    private fun executeWindowOperator() {


    }
}