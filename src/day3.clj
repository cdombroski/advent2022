(ns day3
  (:require [clojure.java.io :as io]
            [clojure.set :as set]))

(defn priority [char]
  (->> char (map int)
       (map #(if (>= % 97)
               (- % 96)
               (- % 38)))))

(defn intersection [llst]
  (->> llst
       (map #(map set %))
       (map #(apply set/intersection %))
       (map first)))

(defn read-char-lines [input]
  (->> input
       line-seq
       (map seq)))

(defn problem1 []
  (with-open [input (io/reader "resource/day3.txt")]
    (->> input
         read-char-lines
         (map #(split-at (/ (count %) 2) %))
         intersection
         priority
         (reduce +))))

(defn problem2 []
  (with-open [input (io/reader "resource/day3.txt")]
    (->> input
         read-char-lines
         (partition 3)
         intersection
         priority
         (reduce +))))

(println (problem1))
(println (problem2))