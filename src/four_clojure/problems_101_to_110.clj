(ns four-clojure.problems-101-to-110)

;; Problem 107: Simple closures
;; Difficulty: Easy
;; Topics: higher order functions maths
;; Lexical scope and first-class functions are two of the most basic building blocks of a functional
;; language like Clojure. When you combine the two together, you get something very powerful called
;; lexical closures. With these, you can exercise a great deal of control over the lifetime of your
;; local bindings, saving their values for use later, long after the code you're running now has
;; finished.
;;
;; It can be hard to follow in the abstract, so let's build a simple closure.
;; Given a positive integer n, return a function (f x) which computes x^n.
;; Observe that the effect of this is to preserve the value of n for use outside the scope in which
;; it is defined.
; (= 256 ((__ 2) 16),
;       ((__ 8) 2))
;
; (= [1 8 27 64] (map (__ 3) [1 2 3 4]))
; (= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))
(fn [n] (fn [x] (int (Math/pow x n))))