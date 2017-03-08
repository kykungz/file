# fileio

|Task|Elapsed Time|
-----|-----------|
Copy file one byte at a time|4.953910 sec
Copy file 1 kilobyte at a time|0.011864 sec
Copy file 4 kilobytes at a time|0.001715 sec
Copy file 64 kilobytes at a time|0.000926 sec
Copy file 128 kilobyte at a time.|0.000913 sec
Copy file 256 kilobyte at a time.|0.000973 sec
Copy file 512 kilobyte at a time.|0.001239 sec
Copy file 5000 kilobyte at a time.|0.006004 sec
Copy file 1 line at a time|0.068913 sec
Copy file 20000 char at a time|0.018760 sec

# Explanation
## Copy file one byte at a time
This task takes longest time (4.953910 seconds) to complete compare to other tasks. Reading file one byte at a time is very time consuming because it creates more process to do when reading/writing. First, it needs to read the file for only one byte, and convert it to an int of ASCII table character. Then, convert the int to byte and write that one byte
