set title 'Test'
set xlabel 'time'
set ylabel 'volume'
set grid
set xrange [-10:10]
set yrange [-10:10]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = (sin(x)+((2.0+(cos(0.0)/sin(0.0)/1.0)+0.0)*log(x)*1.0)+0.0)
plot f(x) title '(sin(x)+((2.0+(cos(0.0)/sin(0.0)/1.0)+0.0)*log(x)*1.0)+0.0)'
