package com.freeankit.rxjava2samples.ui.operators.transformingOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 13/12/2017 (MM/DD/YYYY )
 */
class FlatMapOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeFlatMapOperator() })
    }

    /*Transform the items emitted by an Observable into Observables,
    then flatten the emissions from those into a single Observable*/
    private fun executeFlatMapOperator() {
        getObservable()
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap { integer -> multiplyInt(integer, 2) }
                .flatMap { integer -> multiplyInt(integer, 3) }
                .flatMap { integer -> multiplyInt(integer, 5) }
                .subscribe(getObserver())


    }

    private fun getObservable(): Observable<Int> {
        return Observable.just(1, 2, 3, 4, 5)
    }

    private fun getObserver(): Observer<Int> {
        return object : Observer<Int> {
            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: Int) {
                textView.append(" onNext : value : " + value)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onNext value : " + value)
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

    private fun multiplyInt(integer: Int?, mulplier: Int): Observable<Int> {
        //simulating a heavy duty computational expensive operation
        for (i in 0..100) {
        }
        return Observable.just(integer!! * mulplier)
    }

}