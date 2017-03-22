function delayReturn(delay, value, success = true) {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            if (success) {
                resolve(value);
            } else {
                reject(value);
            }
        }, delay);
    });
}


delayReturn(1000, 'Hello World')
    .then(v => console.log(v), error => console.error('ERROR: ' + error));