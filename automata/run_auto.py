from subprocess import run, PIPE
from datetime import datetime
import os

# creates directory with name year-month-day_hour-minutes
def create_output_dir():
    current_date = datetime.now().strftime("%Y-%m-%d_%H-%M")
    output = "automata/output/" + current_date + "/"
    os.mkdir(output)
    return output
output_dir = create_output_dir()

# runs each scenario separately and writes its output to file
def run_scenario(scenario):
    process = run(['java', '-jar', 'target/ox-0.3.jar'], stdout=PIPE, encoding='utf-8', input=scenario[1])
    game_flow = process.stdout

    results = open(output_dir + scenario[0], "a")
    results.write(game_flow)


# possible scenarios for game with 3x3 board
# checking all win conditions and draw
#
# - each input is followed by '\n' simulating player pressing enter
# - first number choose game board side length (game supports 3 - 40)
# - second chooses starting player (1 for 'O', 2 for 'X')
# - each following number is each player one move
scenarios = [
    ["O_wins_first_row.txt", "3\n1\n1\n5\n2\n7\n3\n"],
    ["O_wins_second_row.txt", "3\n1\n5\n1\n4\n9\n6\n"],
    ["O_wins_third_row.txt", "3\n1\n9\n1\n7\n2\n8\n"],
    ["O_wins_first_column.txt", "3\n1\n1\n5\n4\n3\n7\n"],
    ["O_wins_second_column.txt", "3\n1\n8\n1\n5\n4\n2\n"],
    ["O_wins_third_column.txt", "3\n1\n3\n5\n9\n7\n6\n"],
    ["O_wins_slant_line.txt", "3\n1\n1\n2\n5\n8\n9\n"],
    ["O_wins_reversed_slant_line.txt", "3\n1\n7\n6\n5\n9\n3\n"],
    ["draw.txt", "3\n2\n3\n1\n4\n2\n5\n6\n9\n7\n8\n"]
]

# creates folder with date and time in output
# and runs each scenario
def run_scenarios():
    for scenario in scenarios:
        run_scenario(scenario)

# compares scenario output with templates and writes differences into file
def validate_scenarios():
    total_errors = 0
    for scenario in scenarios:
        with open(output_dir + scenario[0], 'r') as file1:
            with open('automata/templates/' + scenario[0], 'r') as file2:
                different = set(file1).symmetric_difference(file2)

        different.discard('\n')

        with open(output_dir + "RESULTS.adoc", 'a') as file_out:
            file_out.write("=== _" + scenario[0] + "_\n")
            for line in different:
                file_out.write("- Incorrect line: {}\n".format(line))
                total_errors += 1
            file_out.write("\nError count: {}\n\n".format(len(different)))
    with open(output_dir + "RESULTS.adoc", 'a') as file_out:
        file_out.write("\n\n== Total error count: {}\n\n".format(total_errors))

run_scenarios()
validate_scenarios()