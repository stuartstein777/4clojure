(ns four-clojure.problems-91-to-100)

;; Problem 99: product Digits
;; Difficulty: Easy
;; Topics: math seqs
;; Write a function which multiplies two numbers and returns the result as a sequence of its digits.
; (= (__ 1 1) [1])
; (= (__ 99 9) [8 9 1])
; (= (__ 999 99) [9 8 9 0 1])
#((fn seq-prod-iter [x c]
    (if (pos? x)
      (seq-prod-iter (/ (- x (rem x 10)) 10)
                     (conj c (rem x 10)))
      (reverse c)))
   (* % %2) [])