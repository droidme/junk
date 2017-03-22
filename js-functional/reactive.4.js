//
// please check Migrating from RxJS 4 to 5: 
// https://github.com/ReactiveX/rxjs/blob/master/MIGRATION.md#subscription-dispose-is-now-unsubscribe
//

let Rx = require('rxjs/Rx');

// Converting Arrays and Iterables to Observable Stream

let array = [1, 2, 3, 4, 5];

var source = Rx.Observable.from(array);

source.subscribe(
    x => console.log('next: %s', x),
    e => console.error('error: %s', e),
    () => console.log('completed.')
);


// the from method supports also ES6 generators: (https://davidwalsh.name/es6-generators)

function* fibonacci() {
    let fn1 = 1;
    let fn2 = 1;
    while (1) {
        let current = fn2;
        fn2 = fn1;
        fn1 = fn1 + current;
        yield current;
    }
}

var fibSource = Rx.Observable.from(fibonacci()).take(10);

fibSource.subscribe(
    x => console.log('next: %s', x),
    e => console.error('error: %s', e),
    () => console.log('completed.')
);