# fileio

|Task|Elapsed Time|
-----|-----------|
Copy file one byte at a time|4.953910 sec
Copy file 1 kilobyte at a time|0.011864 sec
Copy file 4 kilobytes at a time|0.001715 sec
Copy file 64 kilobytes at a time|0.000869 sec
Copy file 128 kilobyte at a time.|0.000913 sec
Copy file 256 kilobyte at a time.|0.000973 sec
Copy file 512 kilobyte at a time.|0.001239 sec
Copy file 5000 kilobyte at a time.|0.006004 sec
Copy file 1 line at a time|0.068913 sec
Copy file 20000 char at a time|0.018760 sec

# Explanation
## Copy file one byte at a time
This task takes longest time (4.953910 seconds) to complete compare to other tasks. Reading file one byte at a time is very time consuming because it creates more process to do when reading/writing. First, it needs to read the file for only one byte, and convert it to an int of ASCII table character. Then, convert the int to byte and write that one byte onto the file. There are much more steps than other methods.
## Copy file many bytes at a time
This method is much faster than copying it one byte at a time. The steps are the same but it takes less number of time to finish writing. Although we can see that there is a point where the elapsed time starts to increase. Copying data many bytes at a time is faster, until it reaches the limit. When we do the copying process, the data will be stored on memory, waiting to be written on disk. But when it reaches the limit of memory, it will use the disk as virtual memory which is slower than real memory.
## Copy file 1 line at a time
A BufferedReader reads the data into char, and store it in buffer until it found the new line character. We don't know when will it reach the new line character, so it reads the file 1 char at a time and the process is expensive. But this task is still faster than reading one byte at a time because when it reaches the new line character, it writes the whole String into the file.
## Copy file to char array
This task is pretty straight forward. It reads the data 20,000 chars at a time, so the elapsed time is less than copying file 1 line at a time. the readLine() of BufferedReader needs to read until it reaches new line character, but reading to char array doesn't care about special character, it just reads 20,000 chars in to an array and write to the file.
