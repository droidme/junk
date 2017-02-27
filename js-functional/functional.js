/*
 * see: https://codewords.recurse.com/issues/one/an-introduction-to-functional-programming
 */

let names = ['Mary', 'Isla', 'Sam'];
let name_lengths = names.map(item => item.length);

console.log('Names', names);
console.log('Lengths:', name_lengths);

let summe = [1, 2, 3].reduce((a, i) => a + i);
console.log(summe);

/*
 * count how often Sam appears in a list of strings
 */
let sentences = ['Mary read a story to Sam and Isla.',
    'Isla cuddled Sam.',
    'Sam chortled.'
];

let countSam = sentences.reduce((a, s) => a + (s.match(/Sam/g) || []).length, 0);
console.log('Sentences', sentences);
console.log('Sam appears', countSam);


/*
 * Exercise 2, first without filter
 */
let people = [
    { name: 'Mary', height: 160 },
    { name: 'Isla', height: 80 },
    { name: 'Sam' }
];

let height_total = people.reduce((a, p) => 'height' in p ? a + p.height : a, 0);
let height_count = people.reduce((a, p) => 'height' in p ? a + 1 : a, 0);

if (height_count > 0) {
    let average_height = height_total / height_count;
    console.log(average_height);
}

/*
 * Excercise 2, with filter
 */
let heights = people.filter(p => 'height' in p).map(p => p.height);

if (heights.length > 0) {
    let average_height = heights.reduce((a, h) => a + h, 0) / heights.length;
    console.log(average_height);
}