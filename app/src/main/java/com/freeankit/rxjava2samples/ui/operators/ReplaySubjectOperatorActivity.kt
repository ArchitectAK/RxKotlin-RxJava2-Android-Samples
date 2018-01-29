package com.freeankit.rxjava2samples.ui.operators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeankit.rxjava2samples.R
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 29/01/2018 (MM/DD/YYYY )
 */
class ReplaySubjectOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeReplaySubjectOperator() })
    }

    /* ReplaySubject emits to any observer all of the items that were emitted
    * by the source Observable, regardless of when the observer subscribes.
    */
    private fun executeReplaySubjectOperator() {


    }
}