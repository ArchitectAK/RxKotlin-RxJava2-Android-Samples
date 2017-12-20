package com.freeankit.rxjava2samples.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.ui.operators.*

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

    fun startDisposableActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, DisposableOperatorActivity::class.java))
    }

    fun startTakeActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, TakeOperatorActivity::class.java))
    }

    fun startTimerActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, TimerOperatorActivity::class.java))
    }
    fun startFlatMapActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, FlatMapOperatorActivity::class.java))
    }

    fun startIntervalActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, IntervalOperatorActivity::class.java))
    }
    fun startDebounceActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, DebounceOperatorActivity::class.java))
    }

    fun startSingleObserverActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, SingleObserverOperatorActivity::class.java))
    }

    fun startCompletableObserverActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, CompletableObserverOperatorActivity::class.java))
    }

    fun startFlowableActivity(view: View) {
        startActivity(Intent(this@OperatorsActivity, FlowableOperatorActivity::class.java))
    }
}