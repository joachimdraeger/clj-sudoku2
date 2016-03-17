(ns clj-sudoku2.validate-test
  (:require [clojure.test :refer :all]
            [clj-sudoku2.validate :refer :all]))

(def invalid-grid [
                   [0 9 7  0 4 0  6 0 8],
                   [0 0 0  7 0 0  0 1 0],
                   [6 0 0  5 0 0  0 0 0],
        
                   [7 3 0  0 1 2  5 0 0],
                   [1 0 8  6 8 4  3 0 7], ; invalid row/column
                   [0 0 6  3 7 0  0 8 1],
        
                   [0 0 0  0 0 5  0 0 2],
                   [0 6 0  0 0 7  0 0 0],
                   [3 0 5  0 8 0  9 7 0]])

(deftest valid-seq?-test
  (testing "valid-seq?"
           (testing "empty sequence is valid"
                    (is (valid-seq? [])))
           (testing "mixed sequence without doubles is valid"
                    (is (valid-seq? [3 0 1 0 0 5 6])))
           (testing "sequence with doubles is not valid"
                    (is (not (valid-seq? [3 1 3 4]))))))

(deftest column-test
  (testing "column returns column"
           (is (= [0 7 5 0 6 3 0 0 0] (column invalid-grid 3)))))

(deftest valid-grid?-test
  (testing "valid-grid"  
           (testing "returns false for invalid row"
                    (is (not (valid-grid? invalid-grid 3 4))))
           (testing "returns false for invalid column"
                    (is (not (valid-grid? invalid-grid 4 2))))
           (testing "returns true for valid column/row"
                    (is (valid-grid? invalid-grid 1 2)))))
