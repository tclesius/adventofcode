with open('aoc2.txt') as f:
    lines = f.read().splitlines()

    horizontal = 0
    depth = 0

    for instruction in lines:
        i = instruction.split(' ')
        if i[0] == 'forward':
            horizontal += int(i[1])
        if i[0] == 'down':
            depth += int(i[1])
        if i[0] == 'up':
            depth -= int(i[1])

    print(horizontal*depth)


with open('aoc2.txt') as f:
    lines = f.read().splitlines()

    horizontal = 0
    depth = 0
    aim = 0

    for instruction in lines:
        i = instruction.split(' ')
        if i[0] == 'forward':
            horizontal += int(i[1])
            depth += aim * int(i[1])
        if i[0] == 'down':
            aim += int(i[1])
        if i[0] == 'up':
            aim -= int(i[1])

    print(horizontal * depth)
