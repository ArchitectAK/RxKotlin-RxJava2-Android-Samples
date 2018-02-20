package com.freeankit.rxjava2samples.ui.operators.mathematicalOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.MaybeObserver
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 26/12/2017 (MM/DD/YYYY )
 */
class ReduceOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeReduceOperator() })
    }

    private fun executeReduceOperator() {
        getObservable()
                .reduce { t1, t2 -> t1 + t2 }
                .subscribe(getObserver())

    }

    private fun getObservable(): Observable<Int> {
        return Observable.just(1, 2, 3, 4)
    }

    private fun getObserver(): MaybeObserver<Int> {
        return object : MaybeObserver<Int> {
            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onSuccess(value: Int) {
                textView.append(" onSuccess : value : " + value)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onSuccess : value : " + value)
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onError : " + e.message)
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onComplete")
            }
        }
    }
}