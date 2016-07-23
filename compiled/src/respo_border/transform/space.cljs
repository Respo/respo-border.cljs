
(ns respo-border.transform.space
  (:require [respo.alias :refer [div]]
            [respo-border.transform.border :refer [interpose-item]]))

(def default-style {:width "auto", :height "auto"})

(defn interpose-spaces [element space-style]
  (if (contains? element :children)
    (update
      element
      :children
      (fn [children]
        (interpose-item
          []
          0
          children
          (div {:style (merge default-style space-style)}))))))
