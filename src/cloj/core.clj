(ns cloj.core
  (:gen-class))

(def Hello)

(defn hello [] (println Hello))
; (hello)


(defn apt []
  (def  apt "apt.txt")
  (spit apt "git make curl\n")
  (spit apt "leiningen clojure\n"     :append true)
  (spit apt "python3 python3-venv\n"  :append true)
  (spit apt "erlang elixir\n"         :append true)
  (spit apt "build-essential tcc\n"   :append true))
(apt)

(defn reqs []
  (def  reqs "requirements.pip")
  (spit reqs "ply xxhash\n")
  (spit reqs "django\n"               :append true))
(reqs)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

; (-main)
