(ns cloj.core
  (:gen-class))

(defmacro clazz [name,super]
  (if super
    (`def name {:t :class
                :s super
                :v (str name)})
    (`def name {:t :class
                :v (str name)})
  ))

(clazz object nil)

(clazz primitive object)
(clazz atom primitive)
(clazz string primitive)
(clazz number primitive)
(clazz integer number)
(clazz hex integer)
(clazz bin integer)

(clazz container object)
(clazz vector container)
(clazz map container)
(clazz stack container)
(clazz set container)
(clazz queue container)

(clazz active object)
(clazz command active)
(clazz func active)
(clazz env active)

(clazz io object)
(clazz dir io)
(clazz file io)



 (defn hello [] (println Hello))
; (hello)

 (def apt {:t :file
           :path  "apt.txt"
           :lines ["git make curl"
                   "leiningen clojure"
                   "python3 python3-venv"
                   "erlang elixir"
                   "build-essential tcc"]})

 (:t apt)
 (:path apt)
 (clojure.string/join "," (:lines apt))

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
 (vector 1 2e4 "3")


 (comment
   (+)
   (take 5 (cycle [1 2 3]))
   (map + [1 2 3 4])))
