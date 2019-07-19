const fs = require('fs');

fs.unlink('message.txt',()=>{
    console.log("deleted the file.");
});

fs.writeFileSync('message.txt','Hi, I am Jupeter');

fs.mkdir('test',()=>{
    fs.readFile('message.txt','utf-8',(err,data) =>{
        fs.writeFileSync('./test/newMessage.txt',data)
    });
});

console.log(1); 