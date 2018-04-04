package com.freeankit.paginationandlazyloading

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.method.TextKeyListener.clear
import android.view.View
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.functions.Consumer
import io.reactivex.processors.PublishProcessor
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit
import javax.xml.datatype.DatatypeConstants.SECONDS


class MainActivity : AppCompatActivity() {

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: Adapter? = null
    private val compositeDisposable = CompositeDisposable()
    private var loading = false
    private var pageNumber = 1
    private val VISIBLE_THRESHOLD = 1
    private var lastVisibleItem: Int = 0
    private var totalItemCount: Int = 0

    private val paginator: PublishProcessor<Int> = PublishProcessor.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        layoutManager!!.orientation = LinearLayoutManager.VERTICAL
        recyclerView.layoutManager = layoutManager
        adapter = Adapter()
        recyclerView.adapter = adapter
        setUpLoadMoreListener()
        subscribeForData()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun subscribeForData() {
        val disposable = paginator
                .onBackpressureDrop()
                .concatMap(object : Function<Int, Publisher<List<String>>>() {
                    @Throws(Exception::class)
                    fun apply(@NonNull page: Int): Publisher<List<String>> {
                        loading = true
                        progressBar.visibility = View.VISIBLE
                        return dataFromNetwork(page)
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(object : Consumer<List<String>>() {
                    @Throws(Exception::class)
                    fun accept(@NonNull items: MutableList<String>) {
                        adapter?.addData(items)
                        loading = false
                        progressBar.visibility = View.INVISIBLE
                    }
                })

        compositeDisposable.add(disposable)

        paginator.onNext(pageNumber)

    }

    private fun setUpLoadMoreListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView,
                                    dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                totalItemCount = layoutManager?.itemCount!!
                lastVisibleItem = layoutManager?.findLastVisibleItemPosition()!!
                if (!loading && totalItemCount <= lastVisibleItem + VISIBLE_THRESHOLD) {
                    pageNumber++
                    paginator.onNext(pageNumber)
                    loading = true
                }
            }
        })

    }

    private fun dataFromNetwork(page: Int): Flowable<List<String>> {
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map(object : Function<Boolean, List<String>>() {
                    @Throws(Exception::class)
                    fun apply(@NonNull value: Boolean?): List<String> {
                        val items = emptyList<String>() as MutableList
                        for (i in 1..10) {
                            items.add("Item " + (page * 10 + i))
                        }
                        return items
                    }
                })
    }
}
