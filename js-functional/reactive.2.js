//
// please check Migrating from RxJS 4 to 5: 
// https://github.com/ReactiveX/rxjs/blob/master/MIGRATION.md#subscription-dispose-is-now-unsubscribe
//
let Rx = require('rxjs/Rx');

let source = Rx.Observable.range(1, 5);

source.subscribe(
    item => console.log('next: %s', item),
    error => console.error('error: %s', error),
    () => console.log('completed')
);