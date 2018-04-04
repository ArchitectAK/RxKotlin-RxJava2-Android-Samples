package com.freeankit.rxkotlinoperators.ui.RxOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxkotlinoperators.R
import com.freeankit.rxkotlinoperators.utils.Constant
import io.reactivex.Flowable
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_example_operator.*


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 20/12/2017 (MM/DD/YYYY )
 */
class FlowableOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeFlowableOperator() })
    }

    /*
   * simple example using Flowable
   */
    private fun executeFlowableOperator() {

        val observable = Flowable.just(1, 2, 3, 4)
        observable
                .reduce(50) { t1, t2 -> t1 + t2 }
                .subscribe(getObserver())

    }


    private fun getObserver(): SingleObserver<Int> {

        return object : SingleObserver<Int> {


            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onSuccess(value: Int) {
                textView.append(" onSuccess : value : $value")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onSuccess : value : $value")
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onError : " + e.message)
            }
        }
    }
}