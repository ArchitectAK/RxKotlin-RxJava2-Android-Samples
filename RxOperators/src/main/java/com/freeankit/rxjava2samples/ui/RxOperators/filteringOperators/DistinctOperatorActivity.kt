package com.freeankit.rxjava2samples.ui.RxOperators.filteringOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 25/01/2018 (MM/DD/YYYY )
 */
class DistinctOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeDistinctOperator() })
    }

    /*
    * distinct() suppresses duplicate items emitted by the source Observable.
    */
    private fun executeDistinctOperator() {

        getObservable()
                .distinct()
                .subscribe(getObserver())
    }

    private fun getObservable(): Observable<Int> {
        return Observable.just(1, 2, 1, 1, 2, 3, 4, 6, 4)
    }


    private fun getObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: Int) {
                textView.append(" onNext : value : " + value!!)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onNext value : " + value)
            }

            override fun onError(e: Throwable) {
                Log.d(Constant().TAG, " onError : " + e.message)
            }

            override fun onComplete() {
                Log.d(Constant().TAG, " onComplete")
            }
        }
    }
}