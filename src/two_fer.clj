(ns two-fer
  (:require [clojure.spec.alpha :as s]))

(defn two-fer ([] "One for you, one for me.")
  ([name] (clojure.string/join ["One for " name ", one for me." ])))

(s/fdef two-fer/two-fer
          :args (s/alt
                  :unary (s/cat :string-name (s/and string? #(not (int? %))))
                  :nullary (s/cat))

          :ret string?
          :fn (fn [x]
                (if (contains? (-> x :args (get 1)) :string-name)
                  (str "One for " (-> x :args (get 1) :string-name) ", one for me")
                  (str  (:ret x) "One for you, one for me."))))
         ;; #(= (:ret %) (if (contains? (:args %) :nullary) "One for you, one for me." (clojure.string/join ["One for " (-> % :args :unary :string-name) ", one for me."]))))
