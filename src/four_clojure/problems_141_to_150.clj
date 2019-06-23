(ns four-clojure.problems-141-to-150)

;; Problem 143: Dot Product
;; Difficulty: Easy
;; Topics: seqs, maths
;; Create a function that computes the dot product of two sequences.
;; You may assume that the vectors will have the same length.
; (= 0 (__ [0 1 0] [1 0 0]))
; (= 3 (__ [1 1 1] [1 1 1]))
; (= 32 (__ [1 2 3] [4 5 6]))
; (= 256 (__ [2 5 6] [100 10 1]))
#(reduce + (map * %1 %2))

;; Problem 145: For The Win
;; Difficulty: Elementary
;; Topics: core-functions seqs
;; Clojure's for macro is a tremendously versatile mechanism for producing a sequence based on some other sequence(s).
;; It can take some time to understand how to use it properly, but that investment will be paid back with clear, concise sequence-wrangling
;; later. With that in mind, read over these for expressions and try to see how each of them produces the same result.
; (= __ (for [x (range 40)
;            :when (= 1 (rem x 4))]
;        x))
;
; (= __ (for [x (iterate #(+ 4 %) 0)
;            :let [z (inc x)]
;            :while (< z 40)]
;        z))
;
; (= __ (for [[x y] (partition 2 (range 20))]
;        (+ x y)))
'(1 5 9 13 17 21 25 29 33 37)
; Code Golf solution:
(range 1 41 4)