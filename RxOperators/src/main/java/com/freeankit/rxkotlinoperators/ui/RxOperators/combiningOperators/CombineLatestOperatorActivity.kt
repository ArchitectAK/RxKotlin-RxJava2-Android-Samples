package com.freeankit.rxkotlinoperators.ui.RxOperators.combiningOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.freeankit.rxkotlinoperators.R
import kotlinx.android.synthetic.main.activity_example_operator.*

/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 23/03/2018 (MM/DD/YYYY)
 */
class CombineLatestOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({
            //executeCombineLatestOperator() })
        })
    }

//    private fun executeCombineLatestOperator() {
//        val builder = StringBuilder()
//        //combine two observables
//        //notice the sizes of Observables and the output
//
//
//        Observable.combineLatest(
//                        getBoyNames(),
//                        getRollNumber(),
//                        { s, i -> s + " -> " + i })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : Observer<String> {
//                    internal lateinit var d: Disposable
//
//                    override fun onSubscribe(d: Disposable) {
//                        this.d = d
//                    }
//
//                    override fun onNext(s: String) {
//                        builder.append(s).append(Constant().LINE_SEPARATOR)
//                    }
//
//                    override fun onError(e: Throwable) {
//                        Log.e(Constant().TAG, "onError: ", e)
//                        if (!d.isDisposed)
//                            d.isDisposed
//                    }
//
//                    override fun onComplete() {
//                        textView.text = builder.toString()
//                        if (!d.isDisposed)
//                            d.isDisposed
//                    }
//                })
//    }
//
//    private fun getBoyNames(): Observable<String> {
//        return Observable.fromArray("JP", "Bala", "Sahan", "Ankit")
//    }
//
//    private fun getRollNumber(): Observable<Int> {
//        return Observable.fromArray(12, 15, 63, 15, 54, 92)
//    }
}