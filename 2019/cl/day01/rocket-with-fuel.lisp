(defun get-file (filename)
  (with-open-file (stream filename)
                  (loop for line = (read-line stream nil)
                        while line
                        collect (parse-integer line))))

(defun fuel-for-mass (mass)
  (- (floor mass 3) 2))

(defun fuel-for-fuel (mass)
  (if (< (fuel-for-mass mass) 1)
    0
    (+ (fuel-for-mass mass) (fuel-for-fuel (fuel-for-mass mass)))))

(print (apply
        '+
        (mapcar
         (lambda (moduleMass)
           (+ (fuel-for-mass moduleMass) (fuel-for-fuel (fuel-for-mass moduleMass))))
         (get-file "input.txt"))))
