---
marp: true
theme: gaia
style: |
  section.center {
      text-align: center;
  }
---

<!-- paginate: true
_backgroundColor: SteelBlue
_color: white
_class: center
-->

<br>
<br>

# How the JavaScript Engine works

**_~and if we have time~_**

# About Prototypal Inheritance

April 1, 2023
@chan_naru_way

---

<!--
_backgroundColor: SteelBlue
_color: white
-->

## Summary of the V8 engine flow

1. Load scripts(bytes), pass it to a `byte stream decoder`.
2. Decode the bytes into `tokens`, then send those to the `parser`.
3. Generate `nodes` from tokens, and create an `AST`.
4. The `interpreter` generates `byte code` from the AST.
5. The `byte code` and `type feedback` are sent to the `optimizing compiler` to generate optimized `machine code`.

⚠️JavaScript engines enhance performance by reusing optimized machine code. If a different data type is encountered, they revert to interpreting bytecode.

---

<!--
_backgroundColor: SteelBlue
_color: white
-->

## Summary of the Prototypal Inheritance

Prototypal inheritance in JavaScript is a way for objects to inherit properties and methods from other objects, called prototypes, `without using classes`.

This enables code reuse and flexibility in object-oriented programming.

---

## Reference

- 🚀⚙️ JavaScript Visualized: the JavaScript Engine
  - https://dev.to/lydiahallie/javascript-visualized-the-javascript-engine-4cdf
- 🎉👨‍👩‍👧‍👧 JavaScript Visualized: Prototypal Inheritance
  - https://dev.to/lydiahallie/javascript-visualized-prototypal-inheritance-47co
