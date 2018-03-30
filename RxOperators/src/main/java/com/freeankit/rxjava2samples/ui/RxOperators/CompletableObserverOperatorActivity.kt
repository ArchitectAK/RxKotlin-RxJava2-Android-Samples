package com.freeankit.rxjava2samples.ui.RxOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*
import java.util.concurrent.TimeUnit

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 19/12/2017 (MM/DD/YYYY )
 */
class CompletableObserverOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeCompletableObserverOperator() })
    }

    /*
    * simple example using CompletableObserver
    */
    private fun executeCompletableObserverOperator() {
        val completable = Completable.timer(1000, TimeUnit.MILLISECONDS)

        completable
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getCompletableObserver())



    }

    private fun getCompletableObserver(): CompletableObserver {
        return object : CompletableObserver {
            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onComplete")
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onError : " + e.message)
            }
        }
    }
}