set title 'Function'
set xlabel 'x'
set ylabel 'y'
set grid
set xrange [0.0:110.0]
set yrange [0.0:20.0]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = (((log((x**-7.004972889066717))*23.85920996276276)*(log((cos((x--77.41225106923599))+30.094471589133942))**-4.794023008131505))*-6.379265361926029)
plot f(x) title '(((log((x**-7.004972889066717))*23.85920996276276)*(log((cos((x--77.41225106923599))+30.094471589133942))**-4.794023008131505))*-6.379265361926029)', '/home/ronaldo/Documentos/Operator/temp.txt' w p ls 1 title 'points'