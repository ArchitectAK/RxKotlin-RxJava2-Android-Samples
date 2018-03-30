package com.freeankit.rxjava2samples.ui.RxOperators.transformingOperators

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.freeankit.rxjava2samples.R
import com.freeankit.rxjava2samples.model.ApiUser
import com.freeankit.rxjava2samples.model.User
import com.freeankit.rxjava2samples.utils.Constant
import com.freeankit.rxjava2samples.utils.Utils
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_example_operator.*


/**
 * @author Ankit Kumar (ankitdroiddeveloper@gmail.com) on 08/12/2017 (MM/DD/YYYY )
 */
class MapOperatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_example_operator)

        btn.setOnClickListener({ executeMapOperator() })
    }

    /*
      * Here we are getting ApiUser Object from api server
      * then we are converting it into User Object because
      * may be our database support User Not ApiUser Object
      * Here we are using Map Operator to do that
      */
    private fun executeMapOperator() {
        progress.visibility = View.VISIBLE
        getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .map { apiUser -> Utils().convertApiUserListToUserList(apiUser) }
                .subscribe(getObserver())

    }

    private fun getObservable(): Observable<List<ApiUser>> {
        return Observable.create<List<ApiUser>> { e ->
            if (!e.isDisposed) {
                e.onNext(Utils().getApiUserList())
                e.onComplete()
            }
        }
    }

    private fun getObserver(): Observer<List<User>> {
        return object : Observer<List<User>> {

            override fun onSubscribe(d: Disposable) {
                Log.d(Constant().TAG, " onSubscribe : " + d.isDisposed)
            }

            override fun onNext(userList: List<User>) {
                textView.append(" onNext")
                textView.append(Constant().LINE_SEPARATOR)
                for (user in userList) {
                    textView.append(" login Name : " + user.login)
                    textView.append(Constant().LINE_SEPARATOR)
                }
                Log.d(Constant().TAG, " onNext : " + userList.size)
                progress.visibility = View.GONE
            }

            override fun onError(e: Throwable) {
                textView.append(" onError : " + e.message)
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onError : " + e.message)
                progress.visibility = View.GONE
            }

            override fun onComplete() {
                textView.append(" onComplete")
                textView.append(Constant().LINE_SEPARATOR)
                Log.d(Constant().TAG, " onComplete")
                progress.visibility = View.GONE
            }
        }
    }
}