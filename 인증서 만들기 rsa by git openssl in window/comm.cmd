openssl genrsa -out .\jwt.pem 2048
openssl rsa -in .\jwt.pem
openssl rsa -in .\jwt.pem -pubout
pause