C:
cd C:\Program Files\Git\usr\bin
openssl genrsa -out C:\key\jwt.pem 2048
openssl rsa -in C:\key\jwt.pem
openssl rsa -in C:\key\jwt.pem -pubout
pause