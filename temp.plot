set title 'PolOp'
set xlabel 'x'
set ylabel 'y'
set grid
set xrange [-5.0:5.0]
set yrange [-5.0:5.0]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = (1.0+(1.0*(x**4.0))+(1.0*(x**3.0))+(1.0*(x**2.0))+(1.0*(x**1.0)))
plot f(x) title '(1.0+(1.0*(x**4.0))+(1.0*(x**3.0))+(1.0*(x**2.0))+(1.0*(x**1.0)))'
