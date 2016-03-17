(ns clj-sudoku2.util-test
  (:require [clojure.test :refer :all]
            [clj-sudoku2.util :refer :all]))

(deftest replace-cell-test
  (testing "replaces cell at the given coordinate"
           (is (= [[1 2] [3 5]] (replace-cell [[1 2] [3 4]] 1 1 5)))))

(deftest cell-test
  (testing "returns cell at the given coordinate"
           (is (= 4 (cell [[1 2] [3 4]] 1 1)))))

(deftest doublicates?-test
  (testing "returns false for an empty list"
           (is (not (doublicates? []))))
  (testing "returns false for a list without doublicates"
           (is (not (doublicates? [5 3 6]))))
  (testing "returns true for a list with doublicates"
           (is (doublicates? [5 3 6 3]))))

(deftest try-values-test
  (testing "returns nil for empty list"
           (is (= nil (try-values #(true %) []))))
  (testing "returns first result that is not nil"
           (is (= 25 (try-values #(if (= 5 %) (* % %) nil) [3 4 5 6]))))  
  (testing "eturns nil for no match"
           (is (= nil (try-values #(if (= 5 %) (* % %) nil) [3 4 2 6])))))
