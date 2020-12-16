(ns cloj.core
  (:gen-class))

(def Hello)

(defn hello [] (println Hello))
; (hello)

(nil? `(false))

(spit "apt.txt" "git make wget\n")
(spit "apt.txt" "leiningen clojure\n" :append true)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; (-main)
