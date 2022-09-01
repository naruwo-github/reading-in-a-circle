const hoge = true
const hoge1 = false
const tmp = [0, 1, 2]

if (hoge) {
} else {
}

function tmpFunc () {
    if (hoge) {
        tmp.filter(e => e % 2 === 0)
    } else if (!hoge1) {
        tmp.filter(e => e % 2 === 0)
    } else {
        tmp.filter(e => e % 2 === 0)
    }
    tmp.filter(e => e % 2 === 0)
}
