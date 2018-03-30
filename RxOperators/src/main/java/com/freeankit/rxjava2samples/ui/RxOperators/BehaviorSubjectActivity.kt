package com.freeankit.rxjava2samples.ui.RxOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.BehaviorSubject
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 30/01/2018 (MM/DD/YYYY )
 */
class BehaviorSubjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeBehaviorSubjectOperator() })
    }

    /* When an observer subscribes to a BehaviorSubject, it begins by emitting the item most
   * recently emitted by the source Observable (or a seed/default value if none has yet been
   * emitted) and then continues to emit any other items emitted later by the source Observable(s).
   * It is different from Async Subject as async emits the last value (and only the last value)
   * but the Behavior Subject emits the last and the subsequent values also.
   */
    private fun executeBehaviorSubjectOperator() {

        val source = BehaviorSubject.create<Int>()

        source.subscribe(getFirstObserver()) // it will get 1, 2, 3, 4 and onComplete

        source.onNext(1)
        source.onNext(2)
        source.onNext(3)

        /*
         * it will emit 3(last emitted), 4 and onComplete for second observer also.
         */
        source.subscribe(getSecondObserver())

        source.onNext(4)
        source.onComplete()
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