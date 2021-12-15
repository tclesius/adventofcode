import math

import numpy as np

with open('aoc4.txt') as f:
    lines = f.read().splitlines()
    lines = list(filter(None, lines))
    guesses = lines[0]
    boards = []

    for i in range(1, math.ceil(len(lines) / 5)):
        boards.append(
            np.array([[int(x) for x in m.split()] for m in lines[((1 + (i * 5)) - 5):(1 + (i * 5))]]))

    boards = np.array(boards)
    hitboards = np.full(boards.shape, False)
    bingo = np.full(len(boards), False)
    results = []

    for g in map(int, guesses.split(',')):
        hits = np.where(boards == g)

        board = hits[0]
        xs = hits[1]
        ys = hits[2]

        for (b, x, y) in zip(board, xs, ys):
            hitboards[b, x, y] = True

            if ((hitboards[b]).all(axis=0).any() or (hitboards[b]).all(axis=1).any()) and not bingo[b]:
                bingo[b] = True
                results.append(np.sum(boards[b][~hitboards[b]]) * g)

    print(results[0])
    print(results[1])
