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
* `Buffer` -> periodically gather items emitted by an Observable into bundles and emit these bundles rather than emitting the items one at a time

## TODO

Adding more operator examples

## Highlights :
* [SimpleOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/SimpleOperatorActivity.kt) - Using `Simple` operator
* [MapOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/MapOperatorActivity.kt) - Using `Map` operator
* [ZipOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ZipOperatorActivity.kt) - Using `Zip` observer
* [DisposableOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/DisposableOperatorActivity.kt) - Using `Disposable` operator
* [FlatMapOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/FlatMapOperatorActivity.kt) - Using `FlatMap` Operator
* [IntervalOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/IntervalOperatorActivity.kt) - Using `interval` Operator
* [TakeOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/TakeOperatorActivity.kt) - Using `Take` Operator
* [TimerOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/TimerOperatorActivity.kt) - Using `Timer` Operator
* [DebounceOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/DebounceOperatorActivity.kt) - Using `Debounce` Operator
* [SingleObserverOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/SingleObserverOperatorActivity.kt) - Using `Single Observer` Operator
* [FlowableOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/FlowableOperatorActivity.kt) - Using `Flowable`
* [ReduceOperatorActivity](https://github.com/AnkitDroidGit/RxJava-RxKotlin-Android-Samples/blob/master/app/src/main/java/com/freeankit/rxjava2samples/ui/operators/ReduceOperatorActivity.kt) -Using `Reduce` Operator 
* Coming More

### Contact - Let's connect to each other
- [Twitter](https://twitter.com/KumarAnkitRKE)
- [Github](https://github.com/AnkitDroidGit)
- [LinkedIn](https://www.linkedin.com/in/kumarankitkumar/)
- [Facebook](https://www.facebook.com/freeankit)
- [Slack](https://ankitdroid.slack.com)
- [Stackoverflow](https://stackoverflow.com/users/3282461/android)


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
