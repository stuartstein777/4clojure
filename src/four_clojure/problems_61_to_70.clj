(ns four-clojure.problems-61-to-70)

;; Problem 61: Map construction
;; Difficulty: Easy
;; Topics: core-functions
;; Write a function which takes a vector of keys and a vector of values and constructs a map from them.
; (= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})
; (= (__ [1 2 3 4] ["one" "two" "three"]) {1 "one", 2 "two", 3 "three"})
; (= (__ [:foo :bar] ["foo" "bar" "baz"]) {:foo "foo", :bar "bar"})
; Special restrictions; DO NOT USE zipmap
(defn combine'
  ([keys vals] (combine' keys vals {}))
  ([keys vals res]
   (if (or (empty? keys) (empty? vals))
     res
     (combine' (rest keys) (rest vals) (assoc res (first keys) (first vals))))))

; alternate solution
#(->> (map (fn [k v] {k v}) %1 %2)
          (apply merge))

;; Problem 62: Re-implement iterate
;; Difficulty: Easy
;; Topics: seqs core-functions
;; Given a side-effect free function f and an initial value x write a function which returns an
;; infinite lazy sequence of x, (f x), (f (f x)), (f (f (f x))), et
; (= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])
; (= (take 100 (__ inc 0)) (take 100 (range)))
; (= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))
(fn iterate' [f x] (cons x (lazy-seq (iterate' f (f x)))))

;; Problem 64: Intro to Reduce
;; Difficulty: Elementary
;; Topics: seqs
;; Reduce takes a 2 argument function and an optional starting value.
;; It then applies the function to the first 2 items in the sequence (or the starting value and the first element of the
;; sequence).
;; In the next iteration the function will be called on the previous return value and the next item from the sequence,
;; thus reducing the entire collection to one value. Don't worry, it's not as complicated as it sounds.
; (= 15 (reduce __ [1 2 3 4 5]))
; (=  0 (reduce __ []))
; (=  6 (reduce __ 1 [2 3]))
(= 15 (reduce + [1 2 3 4 5]))
(=  0 (reduce + []))
(=  6 (reduce + 1 [2 3]))

;; Problem 66: Greatest Common Divisor
;; Difficulty: Easy
;; Topics:
;; Given two integers, write a function which returns the greatest common divisor.
; (= (__ 2 4) 2)
; (= (__ 10 5) 5)
; (= (__ 5 7) 1)
; (= (__ 1023 858) 33)
#(if (zero? %2) %1 (recur %2 (mod %1 %2)))

;; Problem 68: Recurring Theme
;; Difficulty: Elementary
;; Topics: recursion
;; Clojure only has one non-stack-consuming looping construct: recur.
;; Either a function or a loop can be used as the recursion point. Either way, recur rebinds the bindings of the recursion point
;; to the values it is passed. Recur must be called from the tail-position, and calling it elsewhere will result in an error.
; (= __
;  (loop [x 5
;         result []]
;    (if (> x 0)
;      (recur (dec x) (conj result (+ 2 x)))
;      result)))
(= [7 6 5 4 3 2]
   (loop [x 5
          result []]
     (if (> x 0)
       (recur (dec x) (conj result (+ 2 x)))
       result)))
