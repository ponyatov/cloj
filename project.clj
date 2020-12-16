(defproject cloj "0.0.1"
  :description "Clojure workout"
  :url "https://www.youtube.com/watch?v=ciGyHkDuPAE"
  :dependencies [[org.clojure/clojure "1.10.0"]]
  :main ^:skip-aot cloj.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
