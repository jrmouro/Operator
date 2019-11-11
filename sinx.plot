set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [0:100]
set yrange [0:20]
f(x) = sin(((x*1.0)+(sin(x)+(x+x))))
plot f(x) title 'sin(((x*1.0)+(sin(x)+(x+x))))'
