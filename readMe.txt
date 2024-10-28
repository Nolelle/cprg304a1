SHAPE SORTING APPLICATION
Version 1.0
========================

Installation:
-------------
1. Ensure you have Java JDK 17 or later installed on your system
2. Extract the provided .jar file to your desired location
3. Prepare your input file containing shape data (see File Format section below)

Usage:
------
Run the program from command line using the following format:
java -jar Sort.jar -ffile_name -t[v|h|a] -s[b|s|i|m|q|z]

Arguments:
-f: Input file path (required)
-t: Compare type (required)
    h = height comparison
    v = volume comparison
    a = base area comparison
-s: Sort algorithm (required)
    b = bubble sort
    i = insertion sort
    s = selection sort
    m = merge sort
    q = quick sort
    z = heap sort

Examples:
java -jar Sort.jar -fshapes1.txt -tv -sb  (Sort shapes1.txt by volume using bubble sort)
java -jar Sort.jar -ta -sQ -f"res\shapes1.txt"  (Sort shapes1.txt by area using quick sort)
java -jar Sort.jar -tH -F"C:\temp\shapes1.txt" -sB  (Sort shapes1.txt by height using bubble sort)

