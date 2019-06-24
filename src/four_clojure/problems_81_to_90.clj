(ns four-clojure.problems-81-to-90)

;; Problem 81: Set Intersection
;; Difficulty: Easy
;; Topics: Set Theory
;; Write a function which returns the intersection of two sets. The intersection is the sub-set of items that each set has in common.
; (= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})
; (= (__ #{0 1 2} #{3 4 5}) #{})
; (= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})
(fn [set1 set2]
  (let [s (if (> (count set1) (count set2))
            set1
            set2)]
    (loop [biggest-set s
           result #{}]
      (if (empty? biggest-set)
        result
        (if (contains? set1 (first biggest-set))
          (recur (rest biggest-set) (conj result (first biggest-set)))
          (recur (rest biggest-set) result))))))

;; Problem 83: A Half-Truth
;; Difficulty: Easy
;; Write a function which takes a variable number of booleans. Your function should return true if some of the parameters are true,
;; but not all of the parameters are true. Otherwise your function should return false.
; (= false (__ false false))
; (= true (__ true false))
; (= false (__ true))
; (= true (__ false true false))
; (= false (__ true true true))
; (= true (__ true true true false))
(fn [a & r]
  (let [all (conj r a)]
    (true? (and (some true? all) (some false? all)))))

;; Problem 88: Symmetric Difference
;; Difficulty: Easy
;; Topics: Set theory
;; Write a function which returns the symmetric difference of two sets.
;; The symmetric difference is the set of items belonging to one but not both of the two sets.
; (= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})
; (= (__ #{:a :b :c} #{}) #{:a :b :c})
; (= (__ #{} #{4 5 6}) #{4 5 6})
; (= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})
#(clojure.set/union (clojure.set/difference % %2) (clojure.set/difference %2 %))

