# Bank OCR Kata.

## Requirements

1. Scan file with a number of entries which each look like this:
```
       _  _     _  _  _  _  _ 
     | _| _||_||_ |_   ||_||_|
     ||_  _|  | _||_|  ||_| _|
```
⋅⋅* Each entry is 4 lines long, and each line has 27 characters. The first 3 lines of each entry contain an account number written using pipes and underscores, and the fourth line is blank. Each account number should have 9 digits, all of which should be in the range 0-9. A normal file contains around 500 entries.
⋅⋅* Task is to write a program that can take this file and parse it into actual account numbers.

2. A valid account number has a valid checksum. Validity of account numbers must be ensured. Checksum can be calculated as follows:
```  
account number:  3  4  5  8  8  2  8  6  5
position names:  d9 d8 d7 d6 d5 d4 d3 d2 d1

checksum calculation:
(12+(2*d2)+(3*d3)+...+(9*d9)) mod 11 = 0
``` 

3. Write out a file of account numbers, one for each input file, in this format:
```  
457508000
664371495 ERR
86110??36 ILL
```
⋅⋅*ie the file has one account number per row. If some characters are illegible, they are replaced by a ?. In the case of a wrong checksum, or illegible number, this is noted in a second column indicating status.