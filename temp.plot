set title 'Function'
set xlabel 'x'
set ylabel 'y'
set grid
set xrange [0.0:110.0]
set yrange [0.0:20.0]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = ((log(x)+(2.0*log(x)*1.0)+0.0)+sin(x)+0.0)
plot f(x) title '((log(x)+(2.0*log(x)*1.0)+0.0)+sin(x)+0.0)', '/home/ronaldo/Documentos/Operator/temp.txt' w p ls 1 title 'points'