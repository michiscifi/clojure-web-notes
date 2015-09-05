(ns notebook.tool)
(use 'selmer.filters)

(defn make-uuid
  "macht eine uuid"
  []
  (let [pool (seq "abcdefghijklmnopqrstuvwxyz0123456789")
        pattern (seq "xxx-xxx")]
    (apply str (map (fn [c] (if (= c \x) (rand-nth pool) c)) pattern))))


(defn make-name
  "macht einen hoffentlich schoenen namen"
  []
  (let [pattern (seq "kvkkv")
        vowels (seq "aeoiu")
        consonants (seq "ptkjsrlmn")
        mapfn (fn [c]
                (cond
                  (= c \v) (rand-nth vowels)
                  (= c \k) (rand-nth consonants)
                  :else c))]
    (apply str (map mapfn pattern))))


; not used
(defn make-anti-forgery-field []
  (let [uuid (make-uuid)
        token-name "__anti-forgery-token"]
    (str "<input type='hidden' name='" token-name "' value='" uuid "' />")))

; used to output the anti forgery field
(add-filter! :raw  (fn [x] [:safe x]))

; (doseq [n (range 10 100)] (println n (make-uuid)))
; (dotimes [n 100] (println n  (make-name)))