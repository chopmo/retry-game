(ns retry.keyboard
  (:require [retry.js-utils :as utils]))

(def pressed-keys #{})

(def key-map
  {
   32 :space
   87 :w
   65 :a
   83 :s
   68 :d
   })

(defn key-for-event [event]
  (key-map (.-keyCode event) false))


(defn key-pressed [event]
  (let [key (key-for-event event)]
    (when key
      (set! pressed-keys (conj pressed-keys key)))))

(defn key-released [event]
  (let [key (key-for-event event)]
    (when key
      (set! pressed-keys (disj pressed-keys key)))))

(defn init []
  (.addEventListener js/document "keydown" key-pressed)
  (.addEventListener js/document "keyup" key-released))

