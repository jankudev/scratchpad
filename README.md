# Bandit

Unix / Linux commands practice wargame.

- [Bandit Wargame](https://overthewire.org/wargames/bandit)
- [MayADevBe Blog - solutions](https://mayadevbe.me/tags/bandit/)

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
Detect open HTTPS
```bash
nmap -sV -p31000-32000 localhost

  PORT      STATE SERVICE     VERSION
  31046/tcp open  echo
  31518/tcp open  ssl/echo
  31691/tcp open  echo
  31790/tcp open  ssl/unknown
  31960/tcp open  echo

ncat --ssl localhost 31790

	-----BEGIN RSA PRIVATE KEY-----
	MIIEogIBAAKCAQEAvmOkuifmMg6HL2YPIOjon6iWfbp7c3jx34YkYWqUH57SUdyJ
	imZzeyGC0gtZPGujUSxiJSWI/oTqexh+cAMTSMlOJf7+BrJObArnxd9Y7YT2bRPQ
	Ja6Lzb558YW3FZl87ORiO+rW4LCDCNd2lUvLE/GL2GWyuKN0K5iCd5TbtJzEkQTu
	DSt2mcNn4rhAL+JFr56o4T6z8WWAW18BR6yGrMq7Q/kALHYW3OekePQAzL0VUYbW
	JGTi65CxbCnzc/w4+mqQyvmzpWtMAzJTzAzQxNbkR2MBGySxDLrjg0LWN6sK7wNX
	x0YVztz/zbIkPjfkU1jHS+9EbVNj+D1XFOJuaQIDAQABAoIBABagpxpM1aoLWfvD
	KHcj10nqcoBc4oE11aFYQwik7xfW+24pRNuDE6SFthOar69jp5RlLwD1NhPx3iBl
	J9nOM8OJ0VToum43UOS8YxF8WwhXriYGnc1sskbwpXOUDc9uX4+UESzH22P29ovd
	d8WErY0gPxun8pbJLmxkAtWNhpMvfe0050vk9TL5wqbu9AlbssgTcCXkMQnPw9nC
	YNN6DDP2lbcBrvgT9YCNL6C+ZKufD52yOQ9qOkwFTEQpjtF4uNtJom+asvlpmS8A
	vLY9r60wYSvmZhNqBUrj7lyCtXMIu1kkd4w7F77k+DjHoAXyxcUp1DGL51sOmama
	+TOWWgECgYEA8JtPxP0GRJ+IQkX262jM3dEIkza8ky5moIwUqYdsx0NxHgRRhORT
	8c8hAuRBb2G82so8vUHk/fur85OEfc9TncnCY2crpoqsghifKLxrLgtT+qDpfZnx
	SatLdt8GfQ85yA7hnWWJ2MxF3NaeSDm75Lsm+tBbAiyc9P2jGRNtMSkCgYEAypHd
	HCctNi/FwjulhttFx/rHYKhLidZDFYeiE/v45bN4yFm8x7R/b0iE7KaszX+Exdvt
	SghaTdcG0Knyw1bpJVyusavPzpaJMjdJ6tcFhVAbAjm7enCIvGCSx+X3l5SiWg0A
	R57hJglezIiVjv3aGwHwvlZvtszK6zV6oXFAu0ECgYAbjo46T4hyP5tJi93V5HDi
	Ttiek7xRVxUl+iU7rWkGAXFpMLFteQEsRr7PJ/lemmEY5eTDAFMLy9FL2m9oQWCg
	R8VdwSk8r9FGLS+9aKcV5PI/WEKlwgXinB3OhYimtiG2Cg5JCqIZFHxD6MjEGOiu
	L8ktHMPvodBwNsSBULpG0QKBgBAplTfC1HOnWiMGOU3KPwYWt0O6CdTkmJOmL8Ni
	blh9elyZ9FsGxsgtRBXRsqXuz7wtsQAgLHxbdLq/ZJQ7YfzOKU4ZxEnabvXnvWkU
	YOdjHdSOoKvDQNWu6ucyLRAWFuISeXw9a/9p7ftpxm0TSgyvmfLF2MIAEwyzRqaM
	77pBAoGAMmjmIJdjp+Ez8duyn3ieo36yrttF5NSsJLAbxFpdlc1gvtGCWW+9Cq0b
	dxviW8+TFVEBl1O4f7HVm6EpTscdDxU+bCXWkfjuRb7Dy9GOtt9JPsX8MBTakzh3
	vBgsyi/sN3RqRBcGU40fOoZyfAMT8s1m/uYv52O6IgeuZ/ujbjY=
	-----END RSA PRIVATE KEY-----
```

### Level 17
Diff between files
```bash
diff passwords.new passwords.old
```
x2gLTTjFwMOhQ8oWNbMN362QKxfRqGlO

### Level 18
SSH remote commands
```bash
ssh bandit.labs.overthewire.org -p 2220 -l bandit18 -C cat readme
```
cGWpMaKXVwDUNgPAVJbWYuGHVn9zl3j8

### Level 19
Setuid / Setgid
```bash
./bandit20-do cat /etc/bandit_pass/bandit20 
```
0qXahG8ZjOVMN9Ghs7iOWsCfZyXOUbYO

### Level 20
Opening a listening server to accept request
```bash
echo -n '0qXahG8ZjOVMN9Ghs7iOWsCfZyXOUbYO' | nc -l -p 1234 &
./suconnect 1234
```
EeoULMCra2q0dSkYj561DX7s1CpBuOBt

### Level 21
Cron
```bash
less /etc/cron.d/cronjob_bandit22
less /usr/bin/cronjob_bandit22.sh
less /tmp/t7O6lds9S0RqQh9aMcz6ShpAoZKF7fgv
```
tRae0UfB9v0UzbCdn9cY0gQnds9GF58Q

### Level 22
Cron
```bash
cat /etc/cron.d/cronjob_bandit23
echo I am user 'bandit23' | md5sum | cut -d ' ' -f 1
cat /tmp/8ca319486bfbbc3663ea0fbe81326349
```
0Zf11ioIjMVN551jX3CmStKLYqjk54Ga

### Level 23
Shell script, code injection - submiting script to folder where scripts get auto executed every minute
```bash
# myscript.sh
#!/bin/sh
cat /etc/bandit_pass/bandit24 > /tmp/tmp.B5X29OVWeH/bandit24.pass

chmod +rx myscript.sh
chmod 777 ./
```
gb8KRRCsshuZXI0tUuR6ypOFjiZbf3G8

# Level 24
Bruto-force attack (submitting to HTTP)
```bash
```
