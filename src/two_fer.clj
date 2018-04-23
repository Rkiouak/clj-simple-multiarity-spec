(ns two-fer
  (:require [clojure.spec.alpha :as s]))

(defn two-fer
  ([] "One for you, one for me.")
  ([name] (clojure.string/join ["One for " name ", one for me." ])))

(s/fdef two-fer/two-fer
        :args (s/and (s/alt :string string? :nil nil?)
                     #(or (string? (:string %)) (empty? (:nil %))))
        :ret string?
        :fn (fn [x]
              (= (:ret x)
                 (if (= (-> x :args :key) :nil)
                   ("One for you, one for me.")
                   (clojure.string/join ["One for " (-> x :args second) ", one for me."])))))