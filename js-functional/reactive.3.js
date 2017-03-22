//
// please check Migrating from RxJS 4 to 5: 
// https://github.com/ReactiveX/rxjs/blob/master/MIGRATION.md#subscription-dispose-is-now-unsubscribe
//
let Rx = require('rxjs/Rx');

let source = Rx.Observable.timer(5000, 1000).timestamp();

source.subscribe(
    x => console.log(x.value + ': ' + x.timestamp));