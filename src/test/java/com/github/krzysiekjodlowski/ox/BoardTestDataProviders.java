package com.github.krzysiekjodlowski.ox;

import com.github.krzysiekjodlowski.ox.model.FieldNumber;
import com.github.krzysiekjodlowski.ox.model.Symbol;

class BoardTestDataProviders {

    Object[][] sizesFrom3UpTo10WithRepresentations() {
        return new Object[][]{
                {3, " 1 2 3\n" +
                        " 4 5 6\n" +
                        " 7 8 9\n"},
                {4, "  1  2  3  4\n" +
                        "  5  6  7  8\n" +
                        "  9 10 11 12\n" +
                        " 13 14 15 16\n"},
                {5, "  1  2  3  4  5\n" +
                        "  6  7  8  9 10\n" +
                        " 11 12 13 14 15\n" +
                        " 16 17 18 19 20\n" +
                        " 21 22 23 24 25\n"},
                {6, "  1  2  3  4  5  6\n" +
                        "  7  8  9 10 11 12\n" +
                        " 13 14 15 16 17 18\n" +
                        " 19 20 21 22 23 24\n" +
                        " 25 26 27 28 29 30\n" +
                        " 31 32 33 34 35 36\n"},
                {7, "  1  2  3  4  5  6  7\n" +
                        "  8  9 10 11 12 13 14\n" +
                        " 15 16 17 18 19 20 21\n" +
                        " 22 23 24 25 26 27 28\n" +
                        " 29 30 31 32 33 34 35\n" +
                        " 36 37 38 39 40 41 42\n" +
                        " 43 44 45 46 47 48 49\n"},
                {8, "  1  2  3  4  5  6  7  8\n" +
                        "  9 10 11 12 13 14 15 16\n" +
                        " 17 18 19 20 21 22 23 24\n" +
                        " 25 26 27 28 29 30 31 32\n" +
                        " 33 34 35 36 37 38 39 40\n" +
                        " 41 42 43 44 45 46 47 48\n" +
                        " 49 50 51 52 53 54 55 56\n" +
                        " 57 58 59 60 61 62 63 64\n"},
                {9, "  1  2  3  4  5  6  7  8  9\n" +
                        " 10 11 12 13 14 15 16 17 18\n" +
                        " 19 20 21 22 23 24 25 26 27\n" +
                        " 28 29 30 31 32 33 34 35 36\n" +
                        " 37 38 39 40 41 42 43 44 45\n" +
                        " 46 47 48 49 50 51 52 53 54\n" +
                        " 55 56 57 58 59 60 61 62 63\n" +
                        " 64 65 66 67 68 69 70 71 72\n" +
                        " 73 74 75 76 77 78 79 80 81\n"},
                {10, "   1   2   3   4   5   6   7   8   9  10\n" +
                        "  11  12  13  14  15  16  17  18  19  20\n" +
                        "  21  22  23  24  25  26  27  28  29  30\n" +
                        "  31  32  33  34  35  36  37  38  39  40\n" +
                        "  41  42  43  44  45  46  47  48  49  50\n" +
                        "  51  52  53  54  55  56  57  58  59  60\n" +
                        "  61  62  63  64  65  66  67  68  69  70\n" +
                        "  71  72  73  74  75  76  77  78  79  80\n" +
                        "  81  82  83  84  85  86  87  88  89  90\n" +
                        "  91  92  93  94  95  96  97  98  99 100\n"}
        };
    }
    Object[][] examplesOfMovesStoredInBoardWithRepresentations() throws NumberLowerThanOneException {
        return new Object[][]{
                {FieldNumber.from("1"), Symbol.NAUGHT, " O 2 3\n" +
                        " 4 5 6\n" +
                        " 7 8 9\n"},
                {FieldNumber.from("2"), Symbol.CROSS, " 1 X 3\n" +
                        " 4 5 6\n" +
                        " 7 8 9\n"},
                {FieldNumber.from("5"), Symbol.NAUGHT, " 1 2 3\n" +
                        " 4 O 6\n" +
                        " 7 8 9\n"},
                {FieldNumber.from("8"), Symbol.CROSS, " 1 2 3\n" +
                        " 4 5 6\n" +
                        " 7 X 9\n"},
                {FieldNumber.from("9"), Symbol.NAUGHT, " 1 2 3\n" +
                        " 4 5 6\n" +
                        " 7 8 O\n"},
        };
    }
}
