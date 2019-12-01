(defun get-file (filename)
  (with-open-file (stream filename)
                  (loop for line = (read-line stream nil)
                        while line
                        collect (parse-integer line))))

(defun fuel-per-module (mass)
  (- (floor mass 3) 2))

(print (apply '+ (mapcar #'fuel-per-module (get-file "input.txt"))))
