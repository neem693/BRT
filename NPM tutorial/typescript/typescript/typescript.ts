declare const $:any;

export class App{
    



    constructor(){

        $(document).ready(()=>{
            $("#button1").click(()=>{
                console.log(this);
            })
        })
    
        console.log($);
        console.log('wefwfefwwefwe');

    }
}

let app = new App();




