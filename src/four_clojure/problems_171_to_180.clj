(ns four-clojure.problems-171-to-180)

;; Problem 177
;; Difficulty: Medium
;; Topics
;; When parsing a snippet of code it's often a good idea to do a sanity check to see if all the
;; brackets match up. Write a function that takes in a string and returns truthy if all square [ ]
;; round ( ) and curly { } brackets are properly paired and legally nested, or returns falsey
;; otherwise.
;; (__ "This string has no brackets.")
;; (__ "class Test {
;      public static void main(String[] args) {
;        System.out.println(\"Hello world.\");
;      }
;    }")
;;
;; (not (__ "(start, end]"))
;; (not (__ "())"))
;; (not (__ "())"))
;; (__ "([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))")
;; (not (__ "([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))"))
;; (not (__ "["))
(fn is-balanced [code]
  ((fn parse [code opens]
     (let [next-bracket (first code) needs-closed (first opens)]
       (if (and (true? (empty? code)) (true? (empty? opens)))
         true
         (if (or (= next-bracket \{) (= next-bracket \() (= next-bracket \[))
           (recur (rest code) (cons next-bracket opens))
           (cond
             (or (and (= next-bracket \}) (= needs-closed \{)) (and (= next-bracket \]) (= needs-closed \[)) (and (= next-bracket \)) (= needs-closed \())) (recur (rest code) (rest opens))
              :else false)))))
    (filter #(or (= % \()(= % \))(= % \{)(= % \})(= % \[)(= % \])) (map identity code)) []))

