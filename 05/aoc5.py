import numpy as np
import re


def fun(verticals_only=True):
    with open('aoc5.txt') as f:
        lines = f.read().splitlines()

        Connects = np.array([list(map(int, re.split(',| -> ', line))) for line in lines])
        MapSize = np.amax(Connects) + 1
        Map = np.full((MapSize, MapSize), 0)

        for c in Connects:

            (x1, y1, x2, y2) = c

            xdiff = int(np.diff([x1, x2]))
            ydiff = int(np.diff([y1, y2]))

            if x1 == x2:
                if ydiff < 0:
                    yl = [y1 - i for i in range(abs(ydiff) + 1)]
                else:
                    yl = [y1 + i for i in range(abs(ydiff) + 1)]
                xl = [x1 for i in range(len(yl))]

                for x, y in zip(xl, yl):
                    Map[y][x] += 1

            if y1 == y2 and xdiff != 0:
                if xdiff < 0:
                    xl = [x1 - i for i in range(abs(xdiff) + 1)]
                else:
                    xl = [x1 + i for i in range(abs(xdiff) + 1)]
                yl = [y1 for i in range(len(xl))]

                for x, y in zip(xl, yl):
                    Map[y][x] += 1

            if abs(xdiff) == abs(ydiff) and not verticals_only:
                if xdiff < 0:
                    xl = [x1 - x for x in range(abs(xdiff) + 1)]
                else:
                    xl = [x1 + x for x in range(abs(xdiff) + 1)]
                if ydiff < 0:
                    yl = [y1 - x for x in range(abs(ydiff) + 1)]
                else:
                    yl = [y1 + x for x in range(abs(ydiff) + 1)]

                for x, y in zip(xl, yl):
                    Map[y][x] += 1

            # print(np.where(Map == 0, '.', Map))
        overlaps = (Map > 1).sum()
        return overlaps


print(fun(verticals_only=True))
print(fun(verticals_only=False))
