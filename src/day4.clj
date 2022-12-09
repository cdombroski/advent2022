(ns day4
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(defn problem1 []
  (with-open [input (io/reader "resource/day4.txt")]
    (count (->> input
                line-seq
                (map #(str/split % #","))
                (map (fn [v] (map #(str/split % #"-") v)))
                (map #(concat (first %) (second %)))
                (map (fn [v] (map #(Integer/parseInt %) v)))
                (filter #(or
                          (and (>= (first %) (nth % 2)) (<= (second %) (nth % 3)))
                          (and (<= (first %) (nth % 2)) (>= (second %) (nth % 3)))))))))

(defn problem2 []
  (with-open [input (io/reader "resource/day4.txt")]
    (count (->> input
                line-seq
                (map #(str/split % #","))
                (map (fn [v] (map #(str/split % #"-") v)))
                (map #(concat (first %) (second %)))
                (map (fn [v] (map #(Integer/parseInt %) v)))
                (filter #(or
                          (and (>= (first %) (nth % 2)) (<= (first %) (nth % 3)))
                          (and (>= (second %) (nth % 2)) (<= (second %) (nth % 3)))
                          (and (<= (first %) (nth % 2)) (>= (second %) (nth % 2)))
                          (and (<= (first %) (nth % 3)) (>= (second %) (nth % 3)))))))))

(println (problem1))
(println (problem2))