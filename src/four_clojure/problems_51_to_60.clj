(ns four-clojure.problems-51-to-60)

;; Problem 51: Advanced Destructuring
;; Difficulty: Easy
;; Topics; destructuring
;; Here is an example of some more sophisticated destructuring.
; (= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))
[1 2 3 4 5]

;; Problem 52: Into to Destructuring
;; Difficulty: Elementary
;; Topics: destructuring
;; Let bindings and function parameter lists support destructuring.
; (= [2 4] (let [[a b c d e] [0 1 2 3 4]] __))
(= [2 4] (let [[a b c d e] [0 1 2 3 4]] (conj [] c e)))

;; Problem 57: Simple Recursion
;; Difficulty: Elementary
;; Topics: recursion
;; A recursive function is a function which calls itself. This is one of the fundamental techniques used in functional
;; programming.
; (= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))
(= '(5 4 3 2 1) ((fn foo [x]
                   (when (> x 0)
                     (conj (foo (dec x)) x)))
                  5))
