(ns retry.controls
  (:require [retry.js-utils :as utils]))

(defn update-player [player keys]
  (let []
    (assoc player
      :rotation (+ (:rotation player)
                   (cond
                    (:a keys) -0.1
                    (:d keys) 0.1
                    true 0))
      :acceleration (if (:w keys) [0.3 0] [0 0]))
    
    ))
