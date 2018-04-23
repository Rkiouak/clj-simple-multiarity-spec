(ns two-fer-test
  (:require [clojure.test :refer [deftest is]]
            [two-fer]
            [clojure.spec.gen.alpha :as gen]
            [clojure.spec.alpha :as s]
            [clojure.spec.test.alpha :as stest])
  (:import (clojure.lang ExceptionInfo)))

(deftest run-spec-test-for-two-fer
  (is (= {:total 1, :check-passed 1} (stest/summarize-results (stest/check `two-fer/two-fer {:clojure.spec.test.check/opts {:num-tests 50}})))))

(deftest test-int-arg-for-two-fer
  "Testing spec generated invalid arguments for two-fer"
  (stest/instrument `two-fer)
  (is (thrown? Exception (two-fer/two-fer (int (gen/generate (s/gen int?)))))))