# The flow of JavaScript's asynchronous in single thread
## Asynchronous Schema
JavaScript has 2 queues. First one is called 'Micro Task Queue', and second one is called 'Macro Task Queue'.

* Micro Task Queue: Higher priority queue.
* Macro Task Queue: Lower priority queue.
* Call Stack: Please go to MDN docs [here](https://developer.mozilla.org/en-US/docs/Glossary/Call_stack).
* Processing priority: Call Stack > Micro Task Queue > Macro Task Queue

## Let's check it out!
* Step1: Move to this project in your terminal.
* Step2: Execute `index.js` by the command `node index.js`.
* Result: bellow.

```bash
start: global scope
end: global scope
promise scope
setTimeout scope
```

## Reference
* [JavaScriptはなぜシングルスレッドでも非同期処理ができるのか/Why Can JavaSctipt Invoke Asynchronous in Single Thread?](https://speakerdeck.com/task4233/why-can-javasctipt-invoke-asynchronous-in-single-thread)
