
(ns respo-border.comp.borders-demo
  (:require [respo.alias :refer [create-comp div]]
            [respo.component.text :refer [comp-text]]
            [respo-border.transform.border :refer [interpose-borders]]
            [respo-border.style.layout :as layout]))

(def additional-border-style {:height "1px"})

(def horizontal-style {:width "1px"})

(defn render []
  (fn [state mutate!]
    (div
      {}
      (interpose-borders
        (div
          {:style (merge layout/area layout/column)}
          (comp-text "content-1" layout/cell)
          (comp-text "content-2" layout/cell)
          (comp-text "content-3" layout/cell))
        additional-border-style)
      (interpose-borders
        (div
          {:style (merge layout/area layout/row)}
          (comp-text "content-1" layout/cell)
          (comp-text "content-2" layout/cell)
          (comp-text "content-3" layout/cell))
        horizontal-style))))

(def comp-borders-demo (create-comp :borders-demo render))
