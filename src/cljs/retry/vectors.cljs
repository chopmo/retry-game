(ns retry.vectors)

(defn add [a b]
  (map + a b))

(defn mul [v s]
  (map * v (repeat s)))
