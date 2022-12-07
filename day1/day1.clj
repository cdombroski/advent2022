(ns day1
  (:require [clojure.java.io :as io]))

(defn parse-input [input]
  (loop [lst input
         elves []
         snacks []]
    (if (seq lst)
      (if (= (first lst) "")
        (recur (next lst) (conj elves snacks) [])
        (recur (next lst) elves (conj snacks (Integer/parseInt (first lst)))))
      elves)))

(defn problem1 []
  (with-open [input (io/reader "./day1/input.txt")]
    (let [elves (parse-input (line-seq input))]
      (reduce max (map #(reduce + %) elves)))))
    

(defn problem2 []
  (with-open [input (io/reader "./day1/input.txt")]
    (let [elves (parse-input (line-seq input))]
      (apply + (take 3 (reverse (sort (map #(reduce + %) elves))))))))

(println (problem1))
(println (problem2))