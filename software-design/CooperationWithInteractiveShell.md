# One of the usage of vim.
Convert text files in a directory on a remote server to markdown format.

## Receive shell command's result

'''bash
find . -name '*.txt' | sort | vim -
'''

./1.txt
./2.txt
./3.txt

## Update all file extensions

'''vim
:%s/ .*/mv & &.md/
'''

mv ./1.txt ./1.txt.md
mv ./2.txt ./2.txt.md
mv ./3.txt ./3.txt.md

## Execute contents as shell script!

'''vim
:w !sh
'''
