(ns clj-sudoku2.sudoku-test
  (:require [clojure.test :refer :all]
            [clj-sudoku2.sudoku :refer :all]
            [clj-sudoku2.core :as core]
            [clj-sudoku2.validate-test :as validate-test]))

(def solution [[2 9 7 1 4 3 6 5 8]
               [5 8 3 7 2 6 4 1 9]
               [6 1 4 5 9 8 7 2 3]
               [7 3 9 8 1 2 5 6 4]
               [1 2 8 6 5 4 3 9 7]
               [4 5 6 3 7 9 2 8 1]
               [9 7 1 4 6 5 8 3 2]
               [8 6 2 9 3 7 1 4 5]
               [3 4 5 2 8 1 9 7 6]])

(deftest potential-values-test
  (testing "returns just cell value if not 0"
           (is (= [4] (potential-values [[1 2] [0 4]] 1 1)))
  (testing "returns 1 to 9 if cell value is 0"
           (is (= [1 2 3 4 5 6 7 8 9] (potential-values [[1 2] [0 4]] 0 1))))))

(deftest potential-values-test
  (testing "returns just cell value if not 0"
           (is (= [4] (potential-values [[1 2] [0 4]] 1 1)))
  (testing "returns 1 to 9 if cell value is 0"
           (is (= [1 2 3 4 5 6 7 8 9] (potential-values [[1 2] [0 4]] 0 1))))))

(deftest next-x-test
  (testing "returns next x coordinate"
           (is (= 8 (next-x 7)))
           (is (= 0 (next-x 9)))
           (is (= 0 (next-x 10)))))               
           
(deftest next-y-test
  (testing "returns next y coordinate"
           (is (= 4 (next-y 7 4)))
           (is (= 5 (next-y 9 4)))
           (is (= 11 (next-y 10 10)))))  

(deftest last-coordinate?-test
  (testing "returns next y coordinate"
           (is (not (last-coordinate? 7 7)))
           (is (not (last-coordinate? 8 7)))
           (is (not (last-coordinate? 7 8)))
           (is (last-coordinate? 8 8))
           (is (last-coordinate? 9 9))))

(deftest solve-test
  (testing "returns solution"
           (is (= solution (solve core/start))))
  (testing "returns nil when there is no solution"
           (is (= nil (solve validate-test/invalid-grid)))))

  