package com.freeankit.rxjava2samples.ui.RxOperators.conditionalOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeankit.rxjava2samples.R
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 25/02/2018 (MM/DD/YYYY)
 */
class AmbOperatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeAmbOperator() })
    }

    private fun executeAmbOperator() {
    // TODO
    }

}