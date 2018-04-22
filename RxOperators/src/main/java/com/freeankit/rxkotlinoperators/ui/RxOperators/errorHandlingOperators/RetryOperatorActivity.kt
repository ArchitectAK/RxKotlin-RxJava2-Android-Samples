package com.freeankit.rxkotlinoperators.ui.RxOperators.errorHandlingOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxkotlinoperators.R
import com.freeankit.rxkotlinoperators.utils.Constant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*
import java.util.concurrent.TimeUnit

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 22/04/2018 (MM/DD/YYYY)
 */
class RetryOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeRetryOperator() })
    }


//    if a source Observable emits an error, resubscribe to it in the hopes that it will complete without error

    private fun executeRetryOperator() {
        getObservable()
                .retry()
//                .retryWhen(o -> o.delay(100, TimeUnit.MILLISECONDS))
                .debounce(500, TimeUnit.MILLISECONDS)
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver())
    }

    private fun getObservable(): Observable<Int> {
        return Observable.create { emitter ->
            // send events with simulated time wait
            emitter.onNext(1) // skip
            Thread.sleep(400)
            emitter.onNext(2) // deliver
            Thread.sleep(505)
            emitter.onNext(3) // skip
            Thread.sleep(100)
            emitter.onNext(4) // deliver kj h ihioh
            Thread.sleep(605) ///////////////
            emitter.onNext(5) // deliver
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
                textView.append(" onNext : value : $value")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onNext value : $value")
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