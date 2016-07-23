
(ns respo-border.transform.border
  (:require [respo.alias :refer [hr div create-comp]]
            [hsl.core :refer [hsl]]))

(def default-style
 {:background-color (hsl 0 0 80),
  :width "auto",
  :border "none",
  :height "auto",
  :margin 0})

(defn interpose-item [acc idx children item]
  (if (empty? children)
    acc
    (if (= (count children) 1)
      (conj acc (first children))
      (let [cursor (first children)
            generated-key (str "gen-" idx)
            next-acc (-> acc
                      (conj cursor)
                      (conj [generated-key item]))]
        (recur next-acc (inc idx) (rest children) item)))))

(defn interpose-borders [element border-style]
  (if (contains? element :children)
    (update
      element
      :children
      (fn [children]
        (interpose-item
          []
          0
          children
          (hr {:style (merge default-style border-style)}))))))
