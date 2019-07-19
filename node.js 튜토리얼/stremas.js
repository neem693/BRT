const http = require('http');
const fs = require('fs');


readable.on('data',(data) =>{

    console.log('readable stream is working');
    writable.write(data);

});

const server = http.createServer((req, res) => {
    console.log(req.url);
    if(req.url === '/home' || req.url === "/"){
        fs.createReadStream('./index.html').pipe(res);
    }
    else if(req.url === '/document' ){
        fs.createReadStream('./document.html').pipe(res);
    }
    else if(req.url === '/contacts' ){
        fs.createReadStream('./contacts.html').pipe(res);
    }
  
})

server.listen(5500, '127.0.0.1');


//readable.pipe(writable);