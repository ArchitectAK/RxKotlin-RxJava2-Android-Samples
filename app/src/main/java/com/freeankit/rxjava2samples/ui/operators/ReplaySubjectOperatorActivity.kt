package com.freeankit.rxjava2samples.ui.operators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeankit.rxjava2samples.R
import io.reactivex.subjects.ReplaySubject
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
        val source = ReplaySubject.create<Int>()

        source.subscribe(getFirstObserver()) // it will get 1, 2, 3, 4

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)
        source.onNext(4)
        source.onComplete()

        /*
         * it will emit 1, 2, 3, 4 for second observer also as we have used replay
         */
        source.subscribe(getSecondObserver())

    }
}