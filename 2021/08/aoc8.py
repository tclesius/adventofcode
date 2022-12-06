import numpy as np

with open('aoc8-sm.txt') as f:
    lines = f.read().splitlines()
    inp = np.array([line.split(' | ') for line in lines])
    signal_pattern = np.array([i[0].split(' ') for i in inp])
    output_value = np.array([i[1].split(' ') for i in inp])

    digit_count = np.array([len([*e]) for x in output_value for e in x])
    unique_digit_number = np.sum(np.array([(digit_count == i).sum() for i in [2, 4, 3, 7]]))
    print(unique_digit_number)

    translation = np.array([1, 4, 7, 8])
    translation_number = np.array([2, 4, 3, 7])
    digit = [translation_number[np.nonzero(translation == i)[0]]
             if translation_number[
                    np.nonzero(translation == i)].size > 0 else i
             for i in digit_count]
    print(digit)

    numbers_to_translate = [2, 3, 5, 6, 9]

    # 4 ist in 9(2 mehr)
    #       in 8(3 mehr)
    # 7 ist in 3()

    #  aaaa
    # b    c
    # b    c
    #  dddd
    # e    f
    # e    f
    #  gggg
