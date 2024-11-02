# Bandit

[Bandit Wargame](https://overthewire.org/wargames/bandit)
[Found blog - solutions](https://mayadevbe.me/tags/bandit/)

## Levels

### Level 0
```bash
ssh bandit.labs.overthewire.org -p 2220 -l bandit0 -C 'cat readme'
```
ZjLjTmM6FvvyRnrb2rfNWOZOTa6ip5If

### Level 1
```bash
cat ./-
```
263JGJPfgU6LtdEvgfWU1XP5yac29mFx

### Level 2
```bash
cat 'spaces in this filename'
```
MNk8KNH3Usiio41PRUEoDFPqfxLPlSmx

### Level 3
```bash
cat inhere/...Hiding-From-You
```
2WmrDFRmJIq3IPxneAaMGhap0pFhF3NJ

### Level 4
Detecting human-readable files using `file` command.
```bash
find inhere -type f -exec file {} \; | grep 'ASCII text' | cut -f1 -d\:  | xargs -i cat "{}"
```
4oQYVPkxZOOEOO5pTW81FB8j8lxXGUQw

### Level 5
Finding by size.
```bash
find inhere -type f -not -executable -readable -size 1033c -exec cat {} \;
```
HWasnPhtq9AVKe0dmk45nxy20cvUa6EG

### Level 6
Finding by user/group.
```bash
find / -type f -user bandit7 -group bandit6 -size 33c -exec cat {} \; 2>/dev/null
```
morbNTDkSW6jIlUc0ymOdMaLnOlFVAaj

### Level 7
Finding words near a pattern.
```bash
grep -w millionth data.txt
```
dfwvzFQi4mU0wfNbFOe9RoWskMLg7eEc

### Level 8
Unique lines requires sorted input.
```bash
sort data.txt | uniq -u
```
4CKMh1JI91bUIZZPXDqGanal4xvAg0JM

### Level 9
Printing matches only
```bash
grep -o -E '=+\s*[a-zA-Z0-9]+\b' --binary-files=text data.txt
```
FGUW5ilLVJrxX9kMYMmlN4MgbpfMiqey

### Level 10
```bash
base64 -d data.txt 
```
dtR173fZKb0RRsDFSGsg2RWnpNVj3qRr

### Level 11
Caesar cipher decoding (moving alpha characters by 13 positions)
```bash
cat data.txt | tr 'A-Za-z' 'N-ZA-Mn-za-m'
```
7x16WNeHIi5YkIhWsfFIqoognUTyj9Q4

### Level 12
Recursive decompression and detect compression method with 'file'
```bash
tmpdir=$(mktemp -d); pushd $tmpdir; cp ~/data.txt .
xxd -r data.txt original.file

# on each file perform a 'file "file"' check and based on the alg. use
# decompress technique
gunzip "file
bunzip2 "file"
tar xf "file"
```
FO5dwFsc0cbaIiH0h8J2eUks2vdTDwAn

### Level 13
SSH with explicit key
```bash
scp -P 2220 bandit13@bandit.labs.overthewire.org:sshkey.private .
chmod 700 sshkey.private
ssh -i sshkey.private -l bandit14 -p 2220 bandit.labs.overthewire.org
```

### Level 14
Sending data over HTTP through 'nc'
```bash
cat /etc/bandit_pass/bandit14
echo "MU4VWeTyJk8ROof1qqmcBPaLh7lDCPvS" | nc localhost 30000
```
8xCjnmgoKbGLhHFAZlGE5Tmu4M2tKJQo

### Level 15
Sending data over HTTP(s) with SSL/TLS through 'openssl s_client' or 'ncat'
```bash
openssl s_client -connect localhost:30001
#or
echo "8xCjnmgoKbGLhHFAZlGE5Tmu4M2tKJQo" | ncat --ssl localhost 30001
```
kSkvUpMQ7lBYyCM4GBPvCvT1BfWRy0Dx

### Level 16

