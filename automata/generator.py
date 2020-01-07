import sys

board_size = int(sys.argv[1])
win_condition = int(sys.argv[2])
starting_player = sys.argv[3]
line_type = sys.argv[4]

player = ""
valid_input = True

if (board_size < 3 or board_size > 40):
    print("Wrong board size input! -> {}".format(board_size))
    valid_input = False
if (win_condition < 3 or win_condition > board_size * board_size):
    print("Wrong win condition! -> {}".format(win_condition))
    valid_input = False
if (starting_player == "O"):
    player = 1
elif (starting_player == "X"):
    player = 2
else:
    print("Wrong starting player! -> {}".format(starting_player))
    valid_input = False

if valid_input:
    print('''*** Welcome to OX game! ***
You can quit the game anytime by pressing ctrl+C.
Please select board's side length (whole numbers from 3 to 40)
{}
Select the length of the winning line (numbers from 3 to 6)
{}
Which player should start? (enter 1 if player 'O' and 2 if player'X')
{}
'''.format(board_size, win_condition, player))