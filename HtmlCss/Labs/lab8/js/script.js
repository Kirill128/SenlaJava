function on_click__action(e){
    let action = e.target.innerText
    switch(action){
        case "th(x)":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + Math.tanh(Number.parseInt(input[input.length -1])).toString();
            input_field.value = input_field.value + "th(";
        break;

        case "sin(x)":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + Math.sin(Number.parseInt(input[input.length -1])).toString();
            input_field.value = input_field.value + "sin(";
        break;

        case "ln(x)":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + Math.ln(Number.parseInt(input[input.length -1])).toString();
            input_field.value = input_field.value + "ln(";
        break;

        case "div":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + Math.div(Number.parseInt(input[input.length -1])).toString();
            input_field.value = input_field.value + "div(";
        break;

        case "mod":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + Math.sin(Number.parseInt(input[input.length -1])).toString();
            input_field.value = input_field.value + "mod(";
        break;

        case "¹/x":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            input_field.value = input_field.value + "1/(";
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + "1/" + input[input.length-1];
        break;

        case "x²":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) + Math.pow(Number.parseInt(input[input.length -1]),2).toString();
            input_field.value = input_field.value + "**2";
        break;

        case "²√x":
            //input = input_field.value.split(/(?<!\\d)|(?!\\d)/);
            //input_field.value = input_field.value.substr(0, input_field.value.length - input[input.length -1].length) +  Math.pow(Number.parseInt(input[input.length -1]),0.5).toString();
            input_field.value = input_field.value + "**0.5";
        break;

        case "(":
            input_field.value = input_field.value + "(";
        break;

        case ")":
            input_field.value = input_field.value + ")";
        break;

        case "C":
            input_field.value = '';
        break;

        case "<=":
            input_field.value = input_field.value.substr(0, input_field.value.length-1);
        break;

        case "÷":
            input_field.value = input_field.value + '/';
        break;

        case "×":
            input_field.value = input_field.value + '*';
        break;

        case "-":
            input_field.value = input_field.value + '-';
        break;

        case "+":
            input_field.value = input_field.value + '+';    
        break;

        case "±":
            if(input_field.value.slice(input_field.value.length-2) == "-"){
                input_field.value = input_field.value.substr(0, input_field.value.length-1) + '+' + input_field.value.substr(input_field.value.length-1, input_field.value.length-1)
            }
            input_field.value = input_field.value + '+';    
        break; 
    }
}

function on_click__input(e){

    let input = e.target.innerText
    switch(input){
        case "0":
            input_field.value = input_field.value + '0';    
        break;

        case "1":
            input_field.value = input_field.value + '1';    
        break;

        case "2":
            input_field.value = input_field.value + '2';    
        break;

        case "3":
            input_field.value = input_field.value + '3';    
        break;

        case "4":
            input_field.value = input_field.value + '4';    
        break;

        case "5":
            input_field.value = input_field.value + '5';    
        break;

        case "6":
            input_field.value = input_field.value + '6';    
        break;

        case "7":
            input_field.value = input_field.value + '7';    
        break;

        case "8":
            input_field.value = input_field.value + '8';    
        break;

        case "9":
            input_field.value = input_field.value + '9';    
        break;

        case ".":
            input_field.value = input_field.value + '.';    
        break;

        case ",":
            input_field.value = input_field.value + ',';    
        break;
    }   
}

function th(string){
    let expression = input_field.value.split(/\W+/);
    for(let i = 0; i < expression.length; i++){
        if(expression[i] == "th"){
            input_field.value = input_field.value.replace("th(" + expression[i+1] + ")", Math.tanh(Number.parseInt(expression[i+1])));
        }
    }
}

function sin(string){
    let expression = input_field.value.split(/\W+/);
    for(let i = 0; i < expression.length; i++){
        if(expression[i] == "sin"){
            input_field.value = input_field.value.replace("sin(" + expression[i+1] + ")", Math.sin(Number.parseInt(expression[i+1])));
        }
    }
}

function ln(string){
    let expression = input_field.value.split(/\W+/);
    for(let i = 0; i < expression.length; i++){
        if(expression[i] == "ln"){
            input_field.value = input_field.value.replace("ln(" + expression[i+1] + ")", Math.log(Number.parseInt(expression[i+1]))/Math.log(Math.exp(1)));
        }
    }
}

function div(string){
    let expression = input_field.value.split(/\W+/);
    for(let i = 0; i < expression.length; i++){
        if(expression[i] == "div"){
            input_field.value = input_field.value.replace("div(" + expression[i+1] + "," + expression[i+2] + ")", (Number.parseInt(expression[i+1]) - Number.parseInt(expression[i+1])%Number.parseInt(expression[i+2]))/Number.parseInt(expression[i+2]));
        }
    }
}

function mod(string){
    let expression = input_field.value.split(/\W+/);
    for(let i = 0; i < expression.length; i++){
        if(expression[i] == "mod"){
            input_field.value = input_field.value.replace("mod(" + expression[i+1] + "," + expression[i+2] + ")", Number.parseInt(expression[i+1])%Number.parseInt(expression[i+2]));
        }
    }
}

function on_click(e){
    let action = e.target.innerText
    console.log(input_field.value)
    sin(input_field);
    ln(input_field);
    th(input_field);
    div(input_field);
    mod(input_field);
    input_field.value = eval(input_field.value);
}

let btn = document.getElementsByClassName("button__result")[0]
let input_field = document.getElementsByClassName("result")[0]
let input = input_field.value.split(/(?<!\\d)|(?!\\d)/);

btn.addEventListener('click', on_click)

let elements__action = document.getElementsByClassName("button__action")
for (let i = 0; i < elements__action.length; i++){
    elements__action[i].addEventListener('click', on_click__action);
}

let elements__input = document.getElementsByClassName("button__input")
for (let i = 0; i < elements__input.length; i++){
    elements__input[i].addEventListener('click', on_click__input);
}