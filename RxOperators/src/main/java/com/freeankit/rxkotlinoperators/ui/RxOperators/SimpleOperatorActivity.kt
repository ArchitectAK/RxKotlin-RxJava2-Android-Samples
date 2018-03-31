package com.freeankit.rxkotlinoperators.ui.RxOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.freeankit.rxkotlinoperators.R
import com.freeankit.rxkotlinoperators.utils.Constant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 08/12/2017 (MM/DD/YYYY )
 */
class SimpleOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeSimpleOperator() })
    }

    /*
     * simple example to emit two value one by one
     */
    private fun executeSimpleOperator() {
        progress.visibility = View.VISIBLE
        getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getObserver())
    }

    private fun getObservable(): Observable<String> {
        return Observable.just("RxJava", "RxAndroid")
    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(value: String) {
                textView.append(" onNext : value : " + value)
                textView.append("\n")
                Log.d(Constant().TAG, " onNext : value : " + value)
                progress.visibility = View.GONE
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append("\n")
                Log.d(Constant().TAG, " onError : " + e.message)
                progress.visibility = View.GONE
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append("\n\n")
                Log.d(Constant().TAG, " onComplete")
                progress.visibility = View.GONE
            }
        }
    }
}