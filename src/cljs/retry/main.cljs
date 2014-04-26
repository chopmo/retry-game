(ns retry.main
  (:require [retry.js-utils :as utils]
            [retry.render :as render]))

(defn update [time-delta]
  ;(utils/log time-delta)
  )

(defn timestamp-delta [old new]
  (if old (- new old) 0))

(defn tick [last-timestamp timestamp]
  (update (timestamp-delta last-timestamp timestamp))
  (utils/request-next-frame (partial tick timestamp)))

(defn initialize []
  (let [context (render/create-context)]
    (render/clear-context context)
    (utils/log context)
    (utils/request-next-frame (partial tick nil))))

(utils/domready initialize)
