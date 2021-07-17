(ns four-clojure.problems-41-to-50)

;; Problem 41: Drop every Nth item
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which drops every Nth item from a sequence.
(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])
; (= (__ [:a :b :c :d :e :f] 2) [:a :c :e])
; (= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])
(defn drop-every-nth
  ([col n] (drop-every-nth col n [] 1))
  ([col n res ctr]
   (if (empty? col)
     res
     (do
       (if (not= ctr n)
         (drop-every-nth (rest col) n (conj res (first col)) (inc ctr))
         (drop-every-nth (rest col) n res 1))))))

;; Problem 42: Factorial Fun
;; Difficulty: Easy
;; Topics: math
;; Write a function which calculates factorials.
; (= (__ 1) 1)
; (= (__ 3) 6)
; (= (__ 5) 120)
; (= (__ 8) 40320)
(fn factorial
  ([n] (factorial n 1))
  ([n tot]
   (if (= n 1)
     tot
     (recur (dec n) (* tot n)))))

;; Problem 43: Reverse Interleave
;; Difficulty: Easy
;; Write a function which reverses the interleave process into x number of subsequences.
(fn [xs n] (->> (partition n xs)
                (apply map vector)))

;; Problem 44: Rotate sequence
;; Difficulty: Easy
;; Write a function which can rotate a sequence in either direction.
; (= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))
; (= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))
; (= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))
; (= (__ 1 '(:a :b :c)) '(:b :c :a))
; (= (__ -4 '(:a :b :c)) '(:c :a :b))
(fn [n xs]
  (let [cnt (count xs)]
    (if (neg? n)
      (concat (drop (- cnt (mod (- n) cnt)) xs) (take (- cnt (mod (- n) cnt)) xs))
      (concat (drop (mod n cnt) xs) (take (mod n cnt) xs)))))

;; Problem 45: Intro to iterate
;; Difficulty: Easy
;; Topics: seqs
;; The iterate function can be used to produce an infinite lazy sequence.
; (= __ (take 5 (iterate #(+ 3 %) 1)))
(= '(1 4 7 10 13) (take 5 (iterate #(+ 3 %) 1)))

;; Problem 47: Contain yourself
;; Difficulty: Easy
;; Topics:
;; The contains? function checks if a KEY is present in a given collection.
;; This often leads beginner clojurians to use it incorrectly with numerically
;; indexed collections like vectors and lists.
; (contains? #{4 5 6} __)
; (contains? [1 1 1 1 1] __)
; (contains? {4 :a 2 :b} __)
; (not (contains? [1 2 4] __))
4

;; Problem 48: Intro to some
;; Difficulty: Easy
;; Topics
;; The some function takes a predicate function and a collection.
;; It returns the first logical true value of (predicate x) where x is an item in the collection.
; (= __ (some #{2 7 6} [5 6 7 8]))
; (= __ (some #(when (even? %) %) [5 6 7 8]))
(= 6 (some #{2 7 6} [5 6 7 8]))
(= 6 (some #(when (even? %) %) [5 6 7 8]))

;; Problem 49: Split a sequence
;; Difficulty: Easy
;; Topics: seqs
;; Write a function which will split a sequence into two parts.
; (= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])
; (= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])
; (= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])
; Restrictions: DO NOT USE split-at
#(conj [] (take % %2) (drop % %2))
