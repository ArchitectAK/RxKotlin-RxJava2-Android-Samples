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
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 15/02/2018 (MM/DD/YYYY )
 */
class ThrottleFirstOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeThrottleFirstOperator() })
    }


    /*
   * Using throttleFirst() -> if the source Observable has emitted no items since
   * the last time it was sampled, the Observable that results from this operator
   * will emit no item for that sampling period.
   */
    private fun executeThrottleFirstOperator() {

        getObservable()
                .throttleFirst(500, TimeUnit.MILLISECONDS)
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver())
    }

    private fun getObservable(): Observable<Int> {
        return Observable.create { emitter ->
            // send events with simulated time wait
            Thread.sleep(0)
            emitter.onNext(1) // deliver
            emitter.onNext(2) // skip
            Thread.sleep(505)
            emitter.onNext(3) // deliver
            Thread.sleep(99)
            emitter.onNext(4) // skip
            Thread.sleep(100)
            emitter.onNext(5) // skip
            emitter.onNext(6) // skip
            Thread.sleep(305)
            emitter.onNext(7) // deliver
            Thread.sleep(510)
            emitter.onComplete()
        }
    }

    private fun getObserver(): Observer<Int> {
        return object : Observer<Int> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: Int) {
                textView.append(" onNext : ")
                textView.append(Constant().LINE_SEPARATOR)
                textView.append(" value : " + value)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onNext ")
                Log.d(Constant().TAG, " value : " + value)
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