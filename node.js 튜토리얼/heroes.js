const events = require('events');
const util = require('util');



const Hero = function(name){
     this.name = name;
}

util.inherits(Hero,events.EventEmitter);

const superman = new Hero('Superman'); // {name : 'Superman'}
const birdman = new Hero('birdman'); // {name : 'Superman'}
const batman = new Hero('batman'); // {name : 'Superman'}
console.log(superman);

const heroList =[superman,birdman,batman];

heroList.forEach(function(hero) {
    hero.on('call',function(message){
        console.log(hero.name + 'fights with Joker' + message);
    })
});

superman.emit('call','고마워요');
birdman.emit('call','고마워요');
batman.emit('call','고마워요');