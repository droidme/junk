//
// please check Migrating from RxJS 4 to 5: 
// https://github.com/ReactiveX/rxjs/blob/master/MIGRATION.md#subscription-dispose-is-now-unsubscribe
//
var Rx = require('rxjs/Rx');

var source = Rx.Observable.create(observer => {
    // yield a single value and complete
    observer.next(42);
    observer.complete();
    // any cleanup
    return () => console.log('cleaned up');
});

var subscription = source.subscribe(
    x => console.log('onNext: %s', x),
    e => console.log('onError: %s', e),
    () => console.log('onCompleted')
);

var sub2 = source.subscribe(
    x => console.log('value: ', x)
);

subscription.unsubscribe();