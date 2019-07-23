import _ from 'lodash';
import './style.css';
import Icon from './recycle.png';
import Data from './data.xml';

function component() {
    const element = document.createElement('div');
  
    // Lodash, currently included via a script, is required for this line to work
    element.innerHTML = _.join(['안녕', '웹펩 고양아'], ' ');
    element.classList.add('hello');
   
    //add the image to our exisitng div.
    const myIcon = new Image();
    myIcon.src = Icon;

    element.appendChild(myIcon);

    console.log(Data);
   
    return element;
  }
  
  document.body.appendChild(component());