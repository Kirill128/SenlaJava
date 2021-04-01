function on_click__action(e){
    let action = e.target.innerText
    lastWasEqual=false;
    if(!lastWasSpecialOp)
    switch(action){
        case "int(x)":
            input_field.value = input_field.value + "int(";
            lastWasSpecialOp=true;
        break;

        case "lg(x)":
            input_field.value = input_field.value + "lg(";
            lastWasSpecialOp=true;
        break;

        case "pow(x,d)":
            input_field.value = input_field.value + "pow(";
            lastWasSpecialOp=true;
        break;


        case "Pi":
            input_field.value = input_field.value + "3.14";
            lastWasSpecialOp=true;
        break;
        
        case "¹/x":
            input_field.value = input_field.value + "1/(";
            lastWasSpecialOp=true;
        break;

        case "x²":
            input_field.value = input_field.value + "**2";
            lastWasSpecialOp=true;
        break;

        case "²√x":
            input_field.value = input_field.value + "**0.5";
            lastWasSpecialOp=true;
        break;

        case "(":
            input_field.value = input_field.value + "(";
            lastWasSpecialOp=false;
        break;

        case ")":
            input_field.value = input_field.value + ")";
            lastWasSpecialOp=false;
        break;

        case "C":
            input_field.value = '';
            lastWasSpecialOp=false;
        break;

        case "<=":
            input_field.value = input_field.value.substr(0, input_field.value.length-1);
            lastWasSpecialOp=false;
        break;

        case "÷":
            input_field.value = input_field.value + '/';
            lastWasSpecialOp=false;
        break;

        case "×":
            input_field.value = input_field.value + '*';
            lastWasSpecialOp=false;
        break;

        case "-":
            input_field.value = input_field.value + '-';
            lastWasSpecialOp=false;
        break;

        case "+":
            input_field.value = input_field.value + '+';    
            lastWasSpecialOp=false;
        break;

    }

}

function on_click__input(e){
    wasEqualCheck();
    let input = e.target.innerText
    input_field.value=input_field.value+input
    lastWasEqual=false;
}

function int(string){

    let expression=input_field.value.match(/int(.+)/g);
    if(expression===null)return
    for(let i = 0; i < expression.length; i++){
        let numStr=expression[i].replace("int(","").replace(/\).*/g,"");
        input_field.value = input_field.value.replace("int("+numStr+")", Math.floor(Number.parseFloat(numStr)));  
    }
}

function lg(string){

    let expression=input_field.value.match(/lg(.+)/g);
    if(expression===null)return
    for(let i = 0; i < expression.length; i++){
        let numStr=expression[i].replace("lg(","").replace(/\).*/g,"");
        input_field.value = input_field.value.replace("lg("+numStr+")", Math.log10(Number.parseFloat(numStr)));  
    }
}
function pi(string){

    input_field=input_field.value.replace("Pi",3.14);
    console.log(input_field)
}
function pow(string){

    let expression=input_field.value.match(/pow(.+)/g);
    if(expression===null)return
    for(let i = 0; i < expression.length; i++){
        let numStr=expression[i].replace("pow(","").replace(/\).*/g,"");
        let numArr=numStr.split(/\,/g);
        input_field.value = input_field.value.replace("pow("+numArr[0]+","+numArr[1]+")", Math.pow(Number.parseFloat(numArr[0]),Number.parseFloat(numArr[1])));  
    }
}
function wasEqualCheck(){
    if(lastWasEqual)input_field.value="";
}


function on_click(e){
    let action = e.target.innerText
    // console.log(input_field.value)
    // pi(input_field);
    int(input_field);
    lg(input_field);
    pow(input_field);
    input_field.value = eval(input_field.value);
    lastWasEqual=true;
}

let btn = document.getElementsByClassName("button__result")[0]
let input_field = document.getElementsByClassName("result")[0]

let lastWasEqual=true;
let lastWasOperation=false;
let lastWasSpecialOp=false;
btn.addEventListener('click', on_click)

let elements__action = document.getElementsByClassName("button__action")
for (let i = 0; i < elements__action.length; i++){
    elements__action[i].addEventListener('click', on_click__action);
}

let elements__input = document.getElementsByClassName("button__input")
for (let i = 0; i < elements__input.length; i++){
    elements__input[i].addEventListener('click', on_click__input);
}