# RxKotlinOperators

Learn RxKotlin with simple coding examples

[![GitHub stars](https://img.shields.io/github/stars/badges/shields.svg?style=social&label=Stars)](https://github.com/AnkitDroidGit/RxKotlinOperators-Android)


# Migration from RxKotlin 1.0 to RxKotlin 2.0

To allow having RxKotlin 1 and RxKotlin 2 side-by-side, RxKotlin 2 is under the maven coordinates io.reactivex.rxjava2:rxjava:2.x.y and classes are accessible below io.reactivex.
Users switching from 1.x to 2.x have to re-organize their imports, but carefully.

## Using RxKotlin 2.0 Library in your application

Add this in your build.gradle

`compile 'io.reactivex.rxjava2:rxjava:2.1.1'`

If you are using RxAndroid also, then add the following

`compile 'io.reactivex.rxjava2:rxandroid:2.0.1'`

# Quick Look on few changes done in RxKotlin2 over RxKotlin1

### RxJava1/RxKotlin1 -> RxJava2/RxKotlin2

* `onCompleted` -> `onComplete` - without the trailing d
* `Func1` -> `Function`
* `Func2` -> `BiFunction`
* `CompositeSubscription` -> `CompositeDisposable`
* `limit` operator has been removed - Use `take` in RxKotlin2

....... and so on

# RxOperators :

* `map()` -> Transform the items emitted by an Observable by applying a function to each item
* `zip()` -> Combine the emissions of multiple Observables together via a specified function and emit single items for each combination based on the results of this function
* `take()` -> Emit only the first n items emitted by an Observable
* `timer()` -> Create an Observable that emits a particular item after a given delay
* `flatMap()` -> Transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
* `interval()` -> Create an Observable that emits a sequence of integers spaced by a given time interval
* `debounce()` -> Only emit an item from an Observable if a particular time span has passed without it emitting another item
* `Single Observer` -> A Single is something like an Observable, but instead of emitting a series of values — anywhere from none at all to an infinite number — it always either emits one value or an error notification.
* `reduce()` -> Apply a function to each item emitted by an Observable, sequentially, and emit the final value
* `buffer()` -> Periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
* `filter()` -> Emit only those items from an Observable that pass a predicate test
* `skip()` -> Suppress the first n items emitted by an Observable
* `scan()` -> Apply a function to each item emitted by an Observable, sequentially, and emit each successive value
* `replay()` -> Ensure that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items
* `concat()` -> Emit the emissions from two or more Observables without interleaving them
* `merge()` -> Combine multiple Observables into one by merging their emissions
* `defer()` -> The Defer operator waits until an observer subscribes to it, and then it generates an Observable, typically with an Observable factory function. It does this afresh for each subscriber, so although each subscriber may think it is subscribing to the same Observable, in fact each subscriber gets its own individual sequence.
* `distinct()` -> Suppress duplicate items emitted by an Observable
* `Replay Subject` -> Replays events (in a configurable bounded or unbounded manner) to current and late Observers.
* `Publish Subject` -> Subject that, once an Observer has subscribed, emits all subsequently observed items to the subscriber
* `Behaviour Subject` -> Subject that emits the most recent item it has observed and all subsequent observed items to each subscribed Observer.
* `Aync Subject` -> A Subject that emits the very last value followed by a completion event or the received error to Observers.
* `Throttle First` -> Emit the first items emitted by an Observable within periodic time intervals
* `amb()` -> Given two or more source Observables, emits all of the items from the first of these Observables to emit an item
* `Catch` -> Recover from an onError notification by continuing the sequence without error
* `Retry` -> If a source Observable emits an error, resubscribe to it in the hopes that it will complete without error

* Coming More
## TODO

Adding more operator examples

## Highlights :
* [SimpleOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/SimpleOperatorActivity.kt) - Using `Simple` operator
* [MapOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/transformingOperators/MapOperatorActivity.kt) - Using `Map` operator
* [ZipOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/combiningOperators/ZipOperatorActivity.kt) - Using `Zip` observer
* [DisposableOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/DisposableOperatorActivity.kt) - Using `Disposable` operator
* [FlatMapOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/transformingOperators/FlatMapOperatorActivity.kt) - Using `FlatMap` Operator
* [IntervalOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/creatingOperators/IntervalOperatorActivity.kt) - Using `Interval` Operator
* [TakeOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/filteringOperators/TakeOperatorActivity.kt) - Using `Take` Operator
* [TimerOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/TimerOperatorActivity.kt) - Using `Timer` Operator
* [DebounceOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/filteringOperators/DebounceOperatorActivity.kt) - Using `Debounce` Operator
* [SingleObserverOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/SingleObserverOperatorActivity.kt) - Using `Single Observer` Operator
* [FlowableOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/FlowableOperatorActivity.kt) - Using `Flowable`
* [ReduceOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/mathematicalOperators/ReduceOperatorActivity.kt) -Using `Reduce` Operator 
* [BufferOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/transformingOperators/BufferOperatorActivity.kt) -Using `Buffer` Operator 
* [FilterOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/filteringOperators/FilterOperatorActivity.kt) -Using `Filter` Operator 
* [SkipOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/filteringOperators/SkipOperatorActivity.kt) -Using `Skip` Operator 
* [ScanOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/transformingOperators/ScanOperatorActivity.kt) -Using `Scan` Operator
* [ReplayOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/connectableOperators/ReplayOperatorActivity.kt) -Using `Replay` Operator
* [ConcatOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/mathematicalOperators/ConcatOperatorActivity.kt) -Using `Concat` Operator
* [MergeOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/combiningOperators/MergeOperatorActivity.kt) -Using `Merge` Operator
* [DeferOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/creatingOperators/DeferOperatorActivity.kt) -Using `Defer` Operator
* [DistinctOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/filteringOperators/DistinctOperatorActivity.kt) -Using `Distinct` Operator
* [ReplaySubjectOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/connectableOperators/ReplaySubjectOperatorActivity.kt) -Using `Replay Subject` Operator
* [PublishSubjectOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/connectableOperators/PublishSubjectOperatorActivity.kt) -Using `Publish Subject` Operator
* [BehaviorSubjectActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/BehaviorSubjectActivity.kt) -Using `Behavior Subject` Operator
* [AsyncSubjectOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/AsyncSubjectOperatorActivity.kt) -Using `Aync Subject` Operator
* [ThrottleFirstOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/ThrottleFirstOperatorActivity.kt) -Using `Throttle First` Operator
* [ThrottleLastOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/ThrottleLastOperatorActivity.kt) -Using `Throttle Last` Operator
* [WindowOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/transformingOperators/WindowOperatorActivity.kt) -Using `Window` Operator
* [AmbOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/conditionalOperators/AmbOperatorActivity.kt) -Using `Amb` Operator
* [DelayOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/utilityOperators/DelayOperatorActivity.kt) -Using `Delay` Operator
* [CombineLatestOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/combiningOperators/CombineLatestOperatorActivity.kt)
* [CompletableObserverOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/CompletableObserverOperatorActivity.kt)
* [RepeatWhenOperatorActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxOperators/RepeatWhenOperatorActivity.kt)
* Coming More




# RxBinding

Rx is powerful because we can compose transformations. What that means is that we can have reusable, safe and more functional code that simply plugs into your code.

As an example let’s say we’re making a login screen with an email and a password…

Consider the following rules that we want for our email addresses

- Length should be greater than 6
- Should have a correct email pattern
- Let the user know if any of the above fails
- On each key stroke, verify


## Highlights :
* [RxLoginScreenActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxBinding/RxLoginScreenActivity.kt) - Login Screen using RxBinding


# Pagination And Lazy loading using RxKotlin


## Highlights :
* [PaginationActivity](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxPagination/PaginationActivity.kt) - Activity containing recyclerview and data.
* [PaginationAdapter](https://github.com/AnkitDroidGit/RxKotlinOperators-Android/blob/master/RxOperators/src/main/java/com/freeankit/rxkotlinoperators/ui/RxPagination/PaginationAdapter.kt) - Adapter containing layout item



### Contact - Let's connect to learn together
- [Twitter](https://twitter.com/KumarAnkitRKE)
- [Github](https://github.com/AnkitDroidGit)
- [LinkedIn](https://www.linkedin.com/in/kumarankitkumar/)
- [Facebook](https://www.facebook.com/freeankit)
- [Slack](https://ankitdroid.slack.com)
- [Stackoverflow](https://stackoverflow.com/users/3282461/android)
- [Android App](https://play.google.com/store/apps/details?id=com.freeankit.ankitprofile)


### License

    Copyright 2017 Ankit Kumar
    
    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
