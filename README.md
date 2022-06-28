# Finding the shortest route
## Поиск кратчайшего маршрута
### Релизован при помощи обхода в ширину
 
Задача: Найти кратчайший маршрут на карте и вернуть карту с нарисованным маршрутом.
Программа должна подходить для одноплатного компьютера на базе
процессора RAD750 с частотой 133 МГц и 128 Мбайт динамической памяти. 
Должен использоваться интерфейс RouteFinder:
```java
    /**
    Интерфейс поиска маршрута
    **/
    public interface RouteFinder
    {
    /**
    * Поиск кратчайшего маршрута между двумя точками
    * @param map карта
    * @return карта с построенным маршрутом
    */
    char[][] findRoute(char[][] map);
    }
```

  На вход функции findRoute передается двумерный массив размерностью **K**x**L**
  (1<=**K**,**L**<=10000). В качестве элементов данного массива допускаются следующие
  символы:

    # преграда
    . дорога
    @ начальная точка
    X конечная точка

  Допустимо перемещение только на **соседние клетки по вертикали и по горизонтали** (по
  диагонали перемещение недопустимо). В случае, если построение маршрута
  невозможно, функция findRoute должна вернуть null. В качестве результата необходимо
  получить массив символов с построенным маршрутом. Маршрут прокладывается
  символом ‘+’.

**Пример 1**

<table>
<tr><th>Ввод</th><th> Вывод</th></tr> <!--ряд с ячейками заголовков-->
<tr><td> ...@. <br> .### <br> ..... <br> .X... </td><td> +++@. <br> +#### <br> ++++ <br> .X+++ </td></tr> <!--ряд с ячейками тела таблицы-->
</table>

**Пример 2**

<table>
<tr><th>Ввод</th><th> Вывод</th></tr> <!--ряд с ячейками заголовков-->
<tr><td> ..X.. <br> ##### <br> ..... <br> .@... <br> ..... </td><td> null </td></tr> <!--ряд с ячейками тела таблицы-->
</table>


**Пример 3**

<table>
<tr><th>Ввод</th><th> Вывод</th></tr> <!--ряд с ячейками заголовков-->
<tr><td> ....@ <br> #.### <br> ..... <br> ....X <br> ..... </td><td> .+++@ <br> #+### <br> .+... <br> .+++X <br> ..... </td></tr> <!--ряд с ячейками тела таблицы-->
</table>

# Итог
Пока не выполнены все задачи: поиск осуществляется, 
но не получается пока оптимизировать, что бы для него требовалось 
только 128 мб динамической памяти.
