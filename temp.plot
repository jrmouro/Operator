set title 'Func'
set xlabel 'x'
set ylabel 'y'
set grid
set xrange [0.0:15.0]
set yrange [0.0:50.0]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = (((((x*-1.3379280254309638)+(x**1.476021107631415))-0.7173044442552291)+(x--2.6579206215526963))-0.7173044442552291)
plot f(x) title '(((((x*-1.3379280254309638)+(x**1.476021107631415))-0.7173044442552291)+(x--2.6579206215526963))-0.7173044442552291)', '/home/ronaldo/Documentos/Operator/temp.txt' w p ls 1 title 'points'