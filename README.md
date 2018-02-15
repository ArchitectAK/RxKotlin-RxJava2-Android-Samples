# RxKotlinOperators

Learn RxKotlin with simple coding examples


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

# Operators :
* `Map` -> Transform the items emitted by an Observable by applying a function to each item
* `Zip` -> Combine the emissions of multiple Observables together via a specified function and emit single items for each combination based on the results of this function
* `Take` -> Emit only the first n items emitted by an Observable
* `Timer` -> Create an Observable that emits a particular item after a given delay
* `FlatMap` -> Transform the items emitted by an Observable into Observables, then flatten the emissions from those into a single Observable
* `Interval` -> Create an Observable that emits a sequence of integers spaced by a given time interval
* `Debounce` -> Only emit an item from an Observable if a particular time span has passed without it emitting another item
* `Single Observer` -> A Single is something like an Observable, but instead of emitting a series of values — anywhere from none at all to an infinite number — it always either emits one value or an error notification.
* `Reduce` -> Apply a function to each item emitted by an Observable, sequentially, and emit the final value
* `Buffer` -> Periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time
* `Filter` -> Emit only those items from an Observable that pass a predicate test
* `Skip` -> Suppress the first n items emitted by an Observable
* `Scan` -> Apply a function to each item emitted by an Observable, sequentially, and emit each successive value
* `Replay` -> Ensure that all observers see the same sequence of emitted items, even if they subscribe after the Observable has begun emitting items
* `Concat` -> Emit the emissions from two or more Observables without interleaving them
* `Merge` -> Combine multiple Observables into one by merging their emissions
* `Defer` -> The Defer operator waits until an observer subscribes to it, and then it generates an Observable, typically with an Observable factory function. It does this afresh for each subscriber, so although each subscriber may think it is subscribing to the same Observable, in fact each subscriber gets its own individual sequence.
* `Distinct` -> Suppress duplicate items emitted by an Observable
* `Replay Subject` -> Replays events (in a configurable bounded or unbounded manner) to current and late Observers.
* `Publish Subject` -> Subject that, once an Observer has subscribed, emits all subsequently observed items to the subscriber
* `Behaviour Subject` -> Subject that emits the most recent item it has observed and all subsequent observed items to each subscribed Observer.
* `Aync Subject` -> A Subject that emits the very last value followed by a completion event or the received error to Observers.

* Coming More
## TODO

Adding more operator examples

## Highlights :
* [SimpleOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/SimpleOperatorActivity.kt) - Using `Simple` operator
* [MapOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/MapOperatorActivity.kt) - Using `Map` operator
* [ZipOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ZipOperatorActivity.kt) - Using `Zip` observer
* [DisposableOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/DisposableOperatorActivity.kt) - Using `Disposable` operator
* [FlatMapOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/FlatMapOperatorActivity.kt) - Using `FlatMap` Operator
* [IntervalOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/IntervalOperatorActivity.kt) - Using `Interval` Operator
* [TakeOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/TakeOperatorActivity.kt) - Using `Take` Operator
* [TimerOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/TimerOperatorActivity.kt) - Using `Timer` Operator
* [DebounceOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/DebounceOperatorActivity.kt) - Using `Debounce` Operator
* [SingleObserverOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/SingleObserverOperatorActivity.kt) - Using `Single Observer` Operator
* [FlowableOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/FlowableOperatorActivity.kt) - Using `Flowable`
* [ReduceOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ReduceOperatorActivity.kt) -Using `Reduce` Operator 
* [BufferOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/BufferOperatorActivity.kt) -Using `Buffer` Operator 
* [FilterOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/FilterOperatorActivity.kt) -Using `Filter` Operator 
* [SkipOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/SkipOperatorActivity.kt) -Using `Skip` Operator 
* [ScanOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ScanOperatorActivity.kt) -Using `Scan` Operator
* [ReplayOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ReplayOperatorActivity.kt) -Using `Replay` Operator
* [ConcatOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ConcatOperatorActivity.kt) -Using `Concat` Operator
* [MergeOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/MergeOperatorActivity.kt) -Using `Merge` Operator
* [DeferOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/DeferOperatorActivity.kt) -Using `Defer` Operator
* [DistinctOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/DistinctOperatorActivity.kt) -Using `Distinct` Operator
* [ReplaySubjectOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ReplaySubjectOperatorActivity.kt) -Using `Replay Subject` Operator
* [PublishSubjectOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/PublishSubjectOperatorActivity.kt) -Using `Publish Subject` Operator
* [BehaviorSubjectActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/BehaviorSubjectActivity.kt) -Using `Behavior Subject` Operator
* [AsyncSubjectOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/AsyncSubjectOperatorActivity.kt) -Using `Aync Subject` Operator
* [ThrottleFirstOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ThrottleFirstOperatorActivity.kt) -Using `Throttle First` Operator
 
* Coming More

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
