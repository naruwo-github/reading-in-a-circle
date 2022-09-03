console.log('start: global scope')

setTimeout(() => {
  console.log('setTimeout scope')
}, 0)

Promise.resolve('promise scope')
  .then((res) => {
    console.log(res)
  })

console.log('end: global scope')
