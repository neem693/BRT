C:
cd C:\Program Files\Git\usr\bin
openssl req -new -newkey rsa:2048 -nodes -out C:\key\openssl.csr -keyout C:\key\openssl.key -subj "/C=KR/ST=mapo/L=seoul/O=BM_Cunsulting/OU=developer/CN=www.example.com"
openssl x509 -req -in C:\key\openssl.csr -signkey C:\key\openssl.key -out C:\key\openssl.crt
pause