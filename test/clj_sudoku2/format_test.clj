(ns clj-sudoku2.format-test
  (:require [clojure.test :refer :all]
            [clj-sudoku2.sudoku-test :as sudoku-test]
            [clj-sudoku2.format :refer :all]))

(def formatted-solution (str 
                          "2 9 7  1 4 3  6 5 8\n"
                          "4 8 3  7 5 6  2 1 9\n"
                          "6 1 2  5 9 8  7 4 3\n"
                          "\n"
                          "7 3 9  8 1 2  5 6 4\n"
                          "1 5 8  6 2 4  3 9 7\n"
                          "5 2 6  3 7 9  4 8 1\n"
                          "\n"
                          "8 7 4  9 6 5  1 3 2\n"
                          "9 6 1  4 3 7  8 2 5\n"
                          "3 4 5  2 8 1  9 7 6\n"))

(deftest format-grid-test
  (testing "format-grid should format the grid"
            (is (= formatted-solution (format-grid sudoku-test/solution)))))
