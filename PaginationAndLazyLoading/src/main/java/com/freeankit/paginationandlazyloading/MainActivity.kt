package com.freeankit.paginationandlazyloading

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.processors.PublishProcessor
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Publisher
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    private var layoutManager: LinearLayoutManager? = null
    private var adapter: Adapter? = null
    private val compositeDisposable = CompositeDisposable()
    private var loading = false
    private var pageNumber = 0
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

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

    private fun subscribeForData() {
        val disposable = paginator
                .onBackpressureDrop()
                .concatMap({ page ->
                    loading = true
                    progressBar.visibility = View.VISIBLE
                    dataFromNetwork(page)
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ items ->
                    adapter?.addData(items as MutableList<String>)
                    loading = false
                    progressBar.visibility = View.INVISIBLE
                })

        compositeDisposable.add(disposable)

        paginator.onNext(pageNumber)

    }

    private fun dataFromNetwork(page: Int): Publisher<ArrayList<String>>? {
        return Flowable.just(true)
                .delay(2, TimeUnit.SECONDS)
                .map({
                    val items = ArrayList<String>()
                    for (i in 1..10) {
                        items.add("Item " + (page * 10 + i))
                    }
                    items
                })

    }
}


