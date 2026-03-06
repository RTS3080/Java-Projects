#!/usr/bin/env python3
# (C) Copyright 2021-2024 Hewlett Packard Enterprise Development LP

"""
CodeWars - Check Problem Script

Notes:
    * REQUIRES python3 to run.
    * If Java, Python3, and/or GCC/G++ are not on your system PATH, then
      you must set the full paths below.
    * Data sets are expected to be in a local subdirectory called `student_datasets`
    * Works with .java, .py, .c, .cpp programs.
    * This version compares output while ignoring any trailing whitespaces.
"""

__version__ = "2024.02.13.2"
__author__ = "Nikhil Shanmugham (Updated)"

import argparse
import glob
import os
import re
import subprocess

# Paths for external executables (adjust if not on your PATH)
JDK_PATH = r""
PY3_PATH = r"C:\Users\Ryder\AppData\Local\Programs\Python\Python312\python.exe"
GCC_PATH = r""
GPP_PATH = r""

# **DO NOT** edit these constants
STUDENT_DIR = "data"
INPUT_TEXT_FILE_NAME = "input.txt"
TERMINAL_WIDTH = 80
COMMON_HEADER_PREFIX = "Problem #{} - data set {}"
PROBLEM_OUTPUT_HEADER_TEMPLATE = COMMON_HEADER_PREFIX + " - Program output begins"
DATASET_HEADER_TEMPLATE = COMMON_HEADER_PREFIX + " - INPUT DATA"
EXPECTED_HEADER = "Compare to EXPECTED output below"


def print_green(message):
    """Print a message in green color."""
    print(f"\033[92m{message}\033[0m")


def print_red(message):
    """Print a message in red color."""
    print(f"\033[91m{message}\033[0m")


def get_wide_message(message, fill_char):
    """
    Get a message aligned to the terminal width using a fill char on both sides.

    Left padding is fixed at 4 spaces.
    """
    left_padding = 4
    spaces = 2
    right_padding = TERMINAL_WIDTH - left_padding - len(message) - spaces
    if right_padding < 0:
        right_padding = 0
    return "{} {} {}".format(fill_char * left_padding, message, fill_char * right_padding)


def print_separator(char='*', length=80):
    """Print a separator line using the specified character."""
    print(char * length)


def get_header(message, header_char='-', bar_char='-'):
    """
    Return a formatted header message with a border and padding.
    """
    bar = bar_char * TERMINAL_WIDTH
    return "{}\n{}\n{}\n".format(bar, get_wide_message(message, header_char), bar)


def display_error(message):
    """Display an error message."""
    print(f"!! ERROR: {message}")


def verify_paths():
    """
    Verify that any provided paths for Java, Python, and GCC/G++ are valid.
    Returns True if all paths are valid; otherwise, returns False.
    """
    valid = True

    # Verify JDK path points to the 'bin' directory.
    if JDK_PATH and (not os.path.isdir(JDK_PATH) or os.path.basename(JDK_PATH) != "bin"):
        display_error(f"JDK_PATH was set to `{JDK_PATH}` which is NOT the 'bin' directory of the JDK.")
        valid = False

    for compiler, compiler_path in [("gcc", GCC_PATH), ("gpp", GPP_PATH), ("python", PY3_PATH)]:
        if compiler_path and not os.path.isfile(compiler_path):
            display_error(f"{compiler.upper()}_PATH was set to {compiler_path} which is NOT a file (the {compiler} executable).")
            valid = False

    if not os.path.isdir(STUDENT_DIR):
        display_error(f"{STUDENT_DIR} is missing! Where are the data sets?")
        valid = False

    return valid


def normalize_output(output):
    """
    Normalize output by stripping trailing whitespace from each line.

    :param output: A string representing multi-line output.
    :return: A normalized output string.
    """
    return "\n".join(line.rstrip() for line in output.splitlines())


def check(program_file_path, show_input):
    """
    Check a problem by determining its number, pre-processing the source,
    and then comparing the program's output to expected output.
    """
    problem_number, file_type = determine_problem_number(program_file_path)

    if problem_number:
        print(get_header(f"Checking Problem {problem_number}", header_char='*', bar_char='='))
        run_command = pre_process_source(problem_number, file_type, program_file_path)
        if not run_command:
            display_error("Failed to pre-process source file!")
            return

        check_problem(problem_number, run_command, show_input)
        print(get_header("Checking COMPLETE", header_char='*', bar_char='='))
    else:
        display_error(f"Skipping {program_file_path} because it is not a valid program file.")


def determine_problem_number(program_file_path):
    """
    Determine the problem number and file type based on the filename pattern.

    :param program_file_path: The file path of the program.
    :return: A tuple (problem_number, file_type) if matched; otherwise, (None, None).
    """
    file_name = os.path.basename(program_file_path)
    pattern = r"prob(\d{2})\.(java|py|c|cpp)$"
    match = re.match(pattern, file_name)
    if match:
        return match.group(1), match.group(2)
    return None, None


def pre_process_source(problem_number, file_type, filename):
    """
    Compile or prepare the source file as needed.

    :param problem_number: Problem number.
    :param file_type: File extension/type.
    :param filename: The filename of the source code.
    :return: A run command list/string if successful; otherwise, None.
    """
    run_command = None

    if file_type == "java":
        javac_path = os.path.join(JDK_PATH, "javac") if JDK_PATH else "javac"
        if compile_from_source([javac_path, filename], problem_number, filename, file_type):
            java_command = os.path.join(JDK_PATH, "java") if JDK_PATH else "java"
            run_command = [java_command, "-cp", ".", f"prob{problem_number}"]

    elif file_type == "py":
        python_path = PY3_PATH if PY3_PATH else "python"
        run_command = [python_path, filename]

    elif file_type in ["c", "cpp"]:
        compiler_path = GCC_PATH if file_type == "c" and GCC_PATH else (GPP_PATH if GPP_PATH else "g++")
        problem_exe_name = f"prob{problem_number}.exe"
        compile_command = [compiler_path, "-o", problem_exe_name, filename, "-lm"]
        if compile_from_source(compile_command, problem_number, filename, file_type):
            run_command = problem_exe_name

    return run_command


def compile_from_source(compile_command, problem_number, filename, file_type):
    """
    Compile the source file using the provided command.

    :param compile_command: The compile command list.
    :param problem_number: The problem number.
    :param filename: The filename to compile.
    :param file_type: The type of source file.
    :return: True if compilation was successful, False otherwise.
    """
    print(f"Compiling {file_type} source file...")
    result = subprocess.run(compile_command)
    if result.returncode != 0:
        display_error(f"The {file_type} source file {filename} did not compile for problem {problem_number}.")
        return False
    print("Compilation successful.")
    return True


def check_problem(problem_number, run_command, show_input_file):
    """
    Check each dataset for the given problem number by running the program
    and comparing its output to the expected output, ignoring trailing whitespaces.
    """
    file_pattern = r"prob{}-{}-{}.txt"
    found_dataset = False

    for input_file in sorted(os.listdir(STUDENT_DIR)):
        match = re.match(file_pattern.format(problem_number, r"(\d)", "in"), input_file)
        if not match:
            continue

        found_dataset = True
        dataset_number = match.group(1)
        dataset_input_file = os.path.join(STUDENT_DIR, file_pattern.format(problem_number, dataset_number, "in"))

        with open(dataset_input_file, "r") as f:
            lines = f.readlines()

        print_separator('=')
        print(f"Testing Problem #{problem_number}, Dataset #{dataset_number}")
        print_separator('=')

        if show_input_file:
            print("INPUT DATA:")
            print(''.join(lines))
            print_separator('-')

        # Write input to a temporary file
        with open(INPUT_TEXT_FILE_NAME, "w") as out:
            out.writelines(lines)

        print("PROGRAM OUTPUT:")
        result = subprocess.run(run_command, stdin=open(INPUT_TEXT_FILE_NAME, 'r'),
                                stdout=subprocess.PIPE, text=True)
        program_output = result.stdout.strip()
        print(program_output)
        print_separator('-')

        dataset_output_file = os.path.join(STUDENT_DIR, file_pattern.format(problem_number, dataset_number, "out"))
        with open(dataset_output_file, "r") as f:
            expected_output = f.read().strip()

        print("EXPECTED OUTPUT:")
        print(expected_output)
        print_separator('*')

        # Normalize both outputs to ignore trailing whitespace differences
        if normalize_output(program_output) == normalize_output(expected_output):
            print_green("Output MATCHES expected output!")
        else:
            print_red("Output DOES NOT match expected output!")

        input("Press ENTER to continue with the next dataset...\n")

    if not found_dataset:
        display_error(f"No dataset file found for problem {problem_number}!")


def parse_arguments():
    """
    Parse command-line arguments.

    Returns:
        The parsed arguments.
    """
    parser = argparse.ArgumentParser(
        description="Use this script to check your program! Specify the problem file to test. "
                    "For more information, see the README.txt file."
    )
    parser.add_argument(
        "problem_file",
        help="Specify the problem file you want to test (e.g., prob01.java)",
        type=str
    )
    parser.add_argument(
        "-i", "--show-input",
        help="Show the input file before running your program",
        action="store_true",
        dest="show_input"
    )
    parser.add_argument(
        "--version",
        help="Program version",
        action="version",
        version=f"%(prog)s {__version__}"
    )
    return parser.parse_args()


def main():
    print(f"CodeWars Check Problem Script v{__version__}\n")
    args = parse_arguments()

    if not verify_paths():
        return

    problem_file_path = args.problem_file
    if not os.path.isfile(problem_file_path):
        display_error(f"The specified problem file does not exist: {problem_file_path}")
        return

    check(problem_file_path, args.show_input)

    # Cleanup: remove generated files (executable, class files, or input file)
    for local_file in sorted(os.listdir('.')):
        if re.match(r"prob.*\.class", local_file) or re.match(r"prob.*\.exe", local_file):
            print(f"Cleanup: Removing {local_file}")
            os.remove(local_file)
        elif local_file == INPUT_TEXT_FILE_NAME:
            os.remove(local_file)


if __name__ == "__main__":
    main()