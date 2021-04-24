# File-Processing
An OOP project for file processing.
<br />

## Project's Overview
An implementation of a flexible framework for wokring with files.
The program **filters files** in a given directory according to various conditions, and **order the filenames** that passed the filtering according to various properties.
<br />

### Filter
Filters will return all files in the input **source-directory** that match a certain criterion.

### Order
Order indicates the order in which the already filtered files should be printed.

### Running The Program
**The command line to invoke the program:**
```bash
java fileprocessing.DirectoryProcessor sourcedir commandfile
```
- **sourcedir** - The directory name, in a form of a relative or absolute path.
- **commandfile** - A name of a text file, in a form of a relative or absolute path.

#### Command File Structure
A text file, composed of two or more sections.
Each sections is composed of 2 subsections: **FILTER** and **ORDER**.<br />
Both subsections must appear in every section, as follows: <br />
<img src="https://i.ibb.co/DKmkcrL/Sections.jpg" alt="Sections" width="300" class="center"/>
<br />
<br />

## Attached Files and Directorys
- **src** - The directory that contains the complete program.
- **files_description.txt** - A short explanation about each package, directory and file in the program.

## Notes
- The program was written in Spetember 2020.
