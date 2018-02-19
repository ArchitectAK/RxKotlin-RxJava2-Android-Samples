package com.freeankit.rxjava2samples.ui.operators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.utils.Constant
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*
import java.util.concurrent.TimeUnit

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 19/02/2018 (MM/DD/YYYY )
 */
class WindowOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeWindowOperator() })
    }


    /*
    * Example using window operator -> It periodically
    * subdivide items from an Observable into
    * Observable windows and emit these windows rather than
    * emitting the items one at a time
    */

    private fun executeWindowOperator() {
        Observable.interval(1, TimeUnit.SECONDS).take(12)
                .window(3, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(getConsumer())
    }


/*
* Without Lambda
* */


//    fun getConsumer(): Consumer<Observable<Long>> {
//        return Consumer { observable ->
//            Log.d(Constant().TAG, "Sub Divide begin....")
//            textView.append("Sub Divide begin ....")
//            textView.append(Constant().LINE_SEPARATOR)
//            observable
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(object : Consumer<Long> {
//                        override fun accept(value: Long) {
//                            Log.d(Constant().TAG, "Next:" + value)
//                            textView.append("Next:" + value)
//                            textView.append(Constant().LINE_SEPARATOR)
//                        }
//                    })
//        }
//    }



/*
* With Lambda
* */

    private fun getConsumer(): Consumer<Observable<Long>> {
        return Consumer { observable ->
            Log.d(Constant().TAG, "Sub Divide begin....")
            textView.append("Sub Divide begin ....")
            textView.append(Constant().LINE_SEPARATOR)
            observable
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe { value ->
                        Log.d(Constant().TAG, "Next:" + value)
                        textView.append("Next:" + value)
                        textView.append(Constant().LINE_SEPARATOR)
                    }
        }
    }
}