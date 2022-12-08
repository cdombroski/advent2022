(ns day2 
  (:require [clojure.java.io :as io]))

(defn parse-input []
  (with-open [input (io/reader "./resource/day2.txt")]
    (doall (map #(vec (filter (partial not= \ ) (seq %))) (line-seq input)))))

(defn problem1 []
  (let [sheet (parse-input)]
    (reduce + (map #(case %
                      [\A \X] 4
                      [\A \Y] 8
                      [\A \Z] 3
                      [\B \X] 1
                      [\B \Y] 5
                      [\B \Z] 9
                      [\C \X] 7
                      [\C \Y] 2
                      [\C \Z] 6) sheet))))

(defn problem2 []
  (let [sheet (parse-input)]
    (reduce + (map #(case %
                      [\A \X] 3
                      [\A \Y] 4
                      [\A \Z] 8
                      [\B \X] 1
                      [\B \Y] 5
                      [\B \Z] 9
                      [\C \X] 2
                      [\C \Y] 6
                      [\C \Z] 7) sheet))))

(println (problem1))
(println (problem2))