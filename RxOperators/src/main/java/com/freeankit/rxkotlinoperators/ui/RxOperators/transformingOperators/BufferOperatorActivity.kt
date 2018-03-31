package com.freeankit.rxkotlinoperators.ui.RxOperators.transformingOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxkotlinoperators.R
import com.freeankit.rxkotlinoperators.utils.Constant
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 29/12/2017 (MM/DD/YYYY )
 */
class BufferOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeBufferOperator() })
    }

    /*
        * simple example using buffer operator - bundles all emitted values into a list
        */
    private fun executeBufferOperator() {

        val buffered = getObservable().buffer(3, 1)

        // 3 means,  it takes max of three from its start index and create list
        // 1 means, it jumps one step every time
        // so the it gives the following list
        // 1 - one, two, three
        // 2 - two, three, four
        // 3 - three, four, five
        // 4 - four, five
        // 5 - five

        buffered.subscribe(getObserver())
    }

    private fun getObservable(): Observable<String> {
        return Observable.just("one", "two", "three", "four", "five")
    }

    private fun getObserver(): Observer<List<String>> {
        return object : Observer<List<String>> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(stringList: List<String>) {
                textView.append(" onNext size : " + stringList.size)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onNext : size :" + stringList.size)
                for (value in stringList) {
                    textView.append(" value : " + value)
                    textView.append(Constant().LINE_SEPARATOR)
                    Log.d(Constant().TAG, " : value :" + value)
                }

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