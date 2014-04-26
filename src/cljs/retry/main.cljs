(ns retry.main
  (:require [retry.js-utils :as utils]))

(defn create-context []
  (let [canvas (.createElement js/document "canvas")
        container (.querySelector js/document "body > .container")]
    (set! (. canvas -width) 800)
    (set! (. canvas -height) 600)
    (.appendChild js/container canvas)
    (.getContext canvas "2d")))

(defn clear-context [context]
  (set! (. context -fillStyle) "#ECECEC")
  (.fillRect js/context 0 0 800 600))

(defn update [time-delta]
  ;(utils/log time-delta)
  )

(defn timestamp-delta [old new]
  (if old (- new old) 0))

(defn tick [last-timestamp timestamp]
  (update (timestamp-delta last-timestamp timestamp))
  (utils/request-next-frame (partial tick timestamp)))

(defn initialize []
  (let [context (create-context)]
    (clear-context context)
    (utils/log context)
    (utils/request-next-frame (partial tick nil))))

(utils/domready initialize)
