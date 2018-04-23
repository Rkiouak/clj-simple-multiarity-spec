(defproject two-fer "0.1.0-SNAPSHOT"
  :description "two-fer exercise."
  :url "https://github.com/exercism/clojure/tree/master/exercises/two-fer"
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [expound "0.5.0"]]
  :profiles {:dev {:dependencies [[org.clojure/test.check "0.9.0"]]}}
  :monkeypatch-clojure-test false)
