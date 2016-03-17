(ns clj-sudoku2.all-test
  (:require [clojure.test :refer :all]))

(defn all-tests []
  (run-tests 
    'clj-sudoku2.util-test
    'clj-sudoku2.validate-test
    'clj-sudoku2.sudoku-test
    'clj-sudoku2.format-test))
