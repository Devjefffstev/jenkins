(println "Enter in your name: ") 
(def name (read-line)) 
(println "Hello" name "!!!")

(println "Enter in your age: ") 
(def age (. Integer parseInt (read-line)))
(println name "your age is" age "in 10 years you will be" (+ 10 age))