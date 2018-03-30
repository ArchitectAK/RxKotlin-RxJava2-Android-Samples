package com.freeankit.rxjava2samples.ui.RxOperators

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
import java.util.concurrent.TimeUnit

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 12/12/2017 (MM/DD/YYYY )
 */
class TimerOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeTimerOperator() })
    }

    /*
         * simple example using timer to do something after 2 second
         */
    private fun executeTimerOperator() {
        getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver())

    }

    private fun getObservable(): Observable<out Long> {
        return Observable.timer(2, TimeUnit.SECONDS)
    }

    private fun getObserver(): Observer<Long> {
        return object : Observer<Long> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: Long) {
                textView.append(" onNext : value : " + value)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onNext : value : " + value)
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