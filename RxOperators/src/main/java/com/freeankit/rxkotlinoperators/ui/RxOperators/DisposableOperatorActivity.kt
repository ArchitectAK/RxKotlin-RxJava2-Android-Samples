package com.freeankit.rxkotlinoperators.ui.RxOperators

import android.os.Bundle
import android.os.SystemClock
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.freeankit.rxkotlinoperators.R
import com.freeankit.rxkotlinoperators.utils.Constant
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 11/12/2017 (MM/DD/YYYY )
 */
class DisposableOperatorActivity : AppCompatActivity() {
    private val disposables = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeDisposableOperator() })
    }

    /*
   * Example to understand how to use disposables.
   * disposables is cleared in onDestroy of this activity.
   */
    private fun executeDisposableOperator() {
        progress.visibility = View.VISIBLE
        disposables.add(sampleObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<String>() {
                    override fun onComplete() {

                        textView.append(" onComplete")
                        textView.append(Constant().LINE_SEPARATOR)
                        Log.d(Constant().TAG, " onComplete")
                        progress.visibility = View.GONE
                    }

                    override fun onError(e: Throwable) {
                        textView.append(" onError : " + e.message)
                        textView.append(Constant().LINE_SEPARATOR)
                        Log.d(Constant().TAG, " onError : " + e.message)
                        progress.visibility = View.GONE
                    }

                    override fun onNext(value: String) {
                        textView.append(" onNext : value : " + value)
                        textView.append(Constant().LINE_SEPARATOR)
                        Log.d(Constant().TAG, " onNext value : " + value)
                        progress.visibility = View.GONE
                    }
                }))
    }

    private fun sampleObservable(): Observable<String> {
        return Observable.defer {
            // Do some long running operation
            SystemClock.sleep(2000)
            Observable.just("Firebase", "Fabric", "Analytics", "Github", "LinkedIn")
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposables.clear() // do not send event after activity has been destroyed
    }
}