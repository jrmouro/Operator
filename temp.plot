set title 'Function'
set xlabel 'x'
set ylabel 'y'
set grid
set xrange [0.0:110.0]
set yrange [0.0:20.0]
set style line 1 lc rgb '#0060ad' pt 7 ps 0.5 lt 1 lw 2
f(x) = (((((log(((((x+1.5114182379454122)**1.0)*1.0)*0.5453908892145427))+1.2981715247682029)+0.36981503634871343)**1.0)**1.424749809435148)*1.1734918496470828)
plot f(x) title '(((((log(((((x+1.5114182379454122)**1.0)*1.0)*0.5453908892145427))+1.2981715247682029)+0.36981503634871343)**1.0)**1.424749809435148)*1.1734918496470828)', '/home/ronaldo/Documentos/Operator/temp.txt' w p ls 1 title 'points'