(ns nightcoders.gs-pattern-gen
  (:require [reagent.core :as r]
            [tonejs]))


;;define chords, using :C0 for rests
(def c-maj [:C5 :D5 :E5 :G5])
(def d-maj [:D5 :E5 :F#5 :A5])
(def eb-maj [:Eb5 :F5 :G5 :Bb4])
(def e-maj [:E5 :F#5 :G#5 :B4])
(def fis-maj [:F#5 :G#5 :A#5 :C#5])
(def g-maj [:G5 :A5 :B5 :D5])
(def ab-maj [:Ab5 :Bb5 :C5 :Eb5])
(def bb-maj [:Bb4 :C5 :D5 :F5])
(def b-maj [:B4 :C#5 :D#5 :F#5])

(def db-dom [:Db5 :Eb5 :F5 :Ab5 :B5 :C0])
(def d-dom [:D5 :E5 :F#5 :A5 :C5 :C0])
(def eb-dom [:Eb5 :F5 :G5 :Bb5 :Db5 :C0])
(def f-dom [:F5 :G5 :A5 :C5 :Eb5 :C0])
(def fis-dom [:F#5 :G#5 :A#4 :C#5 :E5 :C0])
(def g-dom [:G5 :A5 :B4 :D5 :F5 :C0])
(def a-dom [:A5 :B4 :C#5 :E5 :G5 :C0])
(def bb-dom [:Bb4 :C5 :D5 :F5 :Ab5 :C0])
(def b-dom [:B4 :C#5 :D#5 :F#5 :A5 :C0])

(def cis-min7 [:C#5 :E5 :G#5 :B4])
(def f-min7 [:F5 :Ab5 :C5 :Eb5])
(def a-min7 [:A4 :C5 :E5 :G5])

(def c-maj7 [:C5 :D5 :E5 :G5 :A5 :B5 :C0])
(def d-maj7 [:D5 :E5 :F#5 :A5 :B5 :C#5 :C0])
(def eb-maj7 [:Eb5 :F5 :G5 :Bb4 :C5 :D5 :C0])
(def g-maj7 [:G5 :A5 :B5 :D5 :E5 :F#5 :C0])
(def bb-maj7 [:Bb4 :C5 :D5 :F5 :G5 :A5 :C0])
(def b-maj7 [:B4 :C#5 :D#5 :F#5 :G#5 :A#5 :C0])

(def c-min [:C5 :D5 :Eb5 :F5])
(def d-min [:D5 :E5 :F5 :G5])
(def e-min [:E5 :F#5 :G5 :A5])

(def eb-wt [:Eb5 :F5 :G5 :A5 :Db5 :C0])
(def e-dyad [:A5 :C6 :C0])
(def f-dom7 [:F5 :A5 :C5 :Eb5])


;;create individual chord patterns
(defn create-from-tetrad [tetrad]
  (shuffle tetrad))

(defn create-from-chord [chord]
  (vec (take 4 (shuffle chord))))

(defn create-from-dyad [dyad]
  (flatten (concat (repeatedly 4 #(take 2 (shuffle dyad))))))


;;create giant steps pattern
(defn make-gs-group []
  (let [gs-group
        (clj->js (flatten (repeatedly 9 #(vec (concat
                                                (create-from-tetrad b-maj)
                                                (create-from-chord d-dom)
                                                (create-from-tetrad g-maj)
                                                (create-from-chord bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-chord eb-maj7)
                                                (create-from-tetrad a-min7)
                                                (create-from-chord d-dom)
                                                (create-from-tetrad g-maj)
                                                (create-from-chord bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-chord fis-dom)
                                                (create-from-tetrad b-maj)
                                                (create-from-chord b-maj7)
                                                (create-from-tetrad f-min7)
                                                (create-from-chord bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-chord eb-maj7)
                                                (create-from-tetrad a-min7)
                                                (create-from-chord d-dom)
                                                (create-from-tetrad g-maj)
                                                (create-from-chord g-maj7)
                                                (create-from-tetrad cis-min7)
                                                (create-from-chord fis-dom)
                                                (create-from-tetrad b-maj)
                                                (create-from-chord b-maj7)
                                                (create-from-tetrad f-min7)
                                                (create-from-chord bb-dom)
                                                (create-from-tetrad eb-maj)
                                                (create-from-chord eb-maj7)
                                                (create-from-tetrad cis-min7)
                                                (create-from-chord fis-dom))))))]
    gs-group))


;;create countdown pattern
(defn make-c-group []
  (let [c-group
        (clj->js (flatten (repeatedly 9 #(vec (concat
                                                (create-from-tetrad e-min)
                                                (create-from-chord f-dom)
                                                (create-from-tetrad bb-maj)
                                                (create-from-chord db-dom)
                                                (create-from-tetrad fis-maj)
                                                (create-from-chord a-dom)
                                                (create-from-tetrad d-maj)
                                                (create-from-chord d-maj7)
                                                (create-from-tetrad d-min)
                                                (create-from-chord eb-dom)
                                                (create-from-tetrad ab-maj)
                                                (create-from-chord b-dom)
                                                (create-from-tetrad e-maj)
                                                (create-from-chord g-dom)
                                                (create-from-tetrad c-maj)
                                                (create-from-chord c-maj7)
                                                (create-from-tetrad c-min)
                                                (create-from-chord db-dom)
                                                (create-from-tetrad fis-maj)
                                                (create-from-chord a-dom)
                                                (create-from-tetrad d-maj)
                                                (create-from-chord f-dom)
                                                (create-from-tetrad bb-maj)
                                                (create-from-chord bb-maj7)
                                                (create-from-dyad e-dyad)
                                                (create-from-tetrad f-dom7)
                                                (create-from-chord f-dom)
                                                (create-from-tetrad bb-maj)
                                                (create-from-chord bb-maj7)
                                                (create-from-chord eb-wt)
                                                (create-from-chord eb-wt))))))]
    c-group))


;;create bass progressions
(def gs-bass-group (array
                     "B2" "D3" "G3" "Bb3" "Eb3" "Eb4" "A3" "D3"
                     "G3" "Bb3" "Eb3" "F#3" "B2" "B3" "F3" "Bb3"
                     "Eb3" "Eb4" "A3" "D3" "G3" "G4" "C#3" "F#3"
                     "B2" "B3" "F3" "Bb3" "Eb3" "Eb4" "C#4" "F#3"))


(def c-bass-group (array
                    "E3" "F3" "Bb2" "Db3" "F#3" "A3" "D3" "D4"
                    "D3" "Eb3" "Ab3" "B3" "E3" "G3" "C3" "C4"
                    "C3" "Db3" "F#3" "A3" "D3" "F3" "Bb2" "Bb3"
                    "E3" "E3" "F3" "F4" "Bb3" "Bb3" "Eb3" "Eb3"))


;;make the synths
(def treble-synth (-> (new js/Tone.Synth
                        {:oscillator {:type "sine"}})
                      (.toMaster)))

(def bass-synth (-> (new js/Tone.Synth
                      {:oscillator {:type "square"}})
                    (.toMaster)))


;;create the lead sequence
(defn create-sequence [group]
  (let [sequence (-> (new js/Tone.Sequence
                       (fn [time note]
                         (.triggerAttackRelease treble-synth note "4n" time))
                       group "8n")
                     (.start 0))]
    sequence))


;;generate the complete synth pattern
(defn generate-pattern [make-group]
  (let [group (make-group)
        sequence (create-sequence group)]
    sequence
    (set! (.-loop sequence) 1)))


;;start and stop the audio transport
(defn play [bass-group tempo]
  (let [bass-seq (-> (new js/Tone.Sequence
                       (fn [time note]
                         (.triggerAttackRelease bass-synth note "4n" time))
                       bass-group "2n")
                     (.start 0))]
    bass-seq
    (set! (.-loop bass-seq) 9))
  (set! (.-value js/Tone.Transport.bpm) tempo)
  (.start js/Tone.Transport "+0.2"))


(defn stop-func []
  (.stop js/Tone.Transport))


;;make the play button toggle-able
(defn toggle [a t1 t2 bass-group tempo]
  (if (= @a t1)
    (do
      (reset! a t2)
      (play bass-group tempo))
    (do
      (reset! a t1)
      (stop-func))))


;;play button takes the bass group and corresponding tempo as arguments
(defn button [bass-group tempo]
  (let [button-text (r/atom "Play")]
    (fn []
      [:div
       [:button
        {:class "btn btn-default"
         :on-click #(toggle button-text "Play" "Pause" bass-group tempo)}
        (deref button-text)]])))


(defn content []
  [:div {:style {:text-align "center"}}
   [:h3 "Chromatic mediant pattern generator"]
   [:br]
   [:p "Giant Steps (John Coltrane)"]
   [:b {:class "btn btn-default"
        :on-click #(generate-pattern make-gs-group)}
    "Generate"]
   [button gs-bass-group 200]
   [:br]
   [:br]
   [:p "Countdown (John Coltrane)"]
   [:b {:class "btn btn-default"
        :on-click #(generate-pattern make-c-group)}
    "Generate"]
   [button c-bass-group 240]
   [:br]
   [:br]
   [:br]
   [:p "Made with ClojureScript, Tone.js, and Nightcoders.net"]
   [:a {:href "https://github.com/vossd/gs-pattern-gen"} "code"]])


(r/render-component [content] (.querySelector js/document "#content"))
