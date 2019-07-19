let fs = require('fs');

const fsTest = fs.readFile('app.js','utf-8', (err, data) => {
    if (err) throw err;
    console.log(data);
    fs.writeFileSync('message.txt',data);
  });

  fs.writeFile('message11.txt','wefwefwf',(err) => {
    if(err) throw err;
    console.log('file completly write');
  });

console.log('efe');