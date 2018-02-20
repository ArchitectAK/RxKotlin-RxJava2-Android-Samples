package com.freeankit.rxjava2samples.ui.operators.connectableOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
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

    private fun getFirstObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " First onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: Int) {
                textView.append(" First onNext : value : " + value!!)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " First onNext value : " + value)
            }

            override fun onError(e: Throwable) {
                textView.append(" First onError : " + e.message)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " First onError : " + e.message)
            }

            override fun onComplete() {
                textView.append(" First onComplete")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " First onComplete")
            }
        }
    }

    private fun getSecondObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                textView.append(" Second onSubscribe : isDisposed :" + d.isDisposed)
                Log.d(Constant().TAG, " Second onSubscribe : " + d.isDisposed)
                textView.append(Constant().LINE_SEPARATOR)
            }

            override fun onNext(value: Int) {
                textView.append(" Second onNext : value : " + value!!)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " Second onNext value : " + value)
            }

            override fun onError(e: Throwable) {
                textView.append(" Second onError : " + e.message)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " Second onError : " + e.message)
            }

            override fun onComplete() {
                textView.append(" Second onComplete")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " Second onComplete")
            }
        }
    }
}