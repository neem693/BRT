const http = require('http');

const server = http.createServer((req,res) =>{
    res.writeHead(200);
    res.end('Okay, I am listening your request, give me one.');
    console.log('Server is listening...');
})

server.listen(5500,'127.0.0.1');

console.log('');
console.log('server is running');