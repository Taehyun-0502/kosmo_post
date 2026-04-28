
console.log("member join")

const username=document.getElementById("username")
const password=document.getElementById("password")
const passwordCheck=document.getElementById("passwordCheck")
const email=document.getElementById("email")
const date=document.getElementById("date")
const phone=document.getElementById("phone")
const btn=document.getElementById("btn")
const username_result=document.getElementById("username_result")
const password_result=document.getElementById("password_result")
const passwordCheck_result=document.getElementById("passwordCheck_result")
const name = document.getElementById("name")

username.addEventListener("blur",function(){
    
    console.log(username.value)
    username.value.replace(" ","")
    if(username.value.length<1){

   username_result.innerText="id는필수 입니다"

    }else{
        username_result.innerText="";
    }
    console.log("start")
    fetch(`./idCheck?username=${username.value}`)
    .then(res=>res.text())
    .then(res=> {
         if(res.trim()=='1'){
            console.log("중복아님")
            username_result.innerText="id가 사용가능합니다"
         }else if(res.trim()=='0'){
            console.log("중복임")
            username_result.innerText="id가 중복입니다"
         }      


    })
    

})

password.addEventListener("blur",function(){
    if(password.value.length<6){
        password_result.innerText="password는6자리 이상!"

    }else{
        password_result.innerText=""
    }


})

passwordCheck.addEventListener("blur",function(){
    if(passwordCheck.value==password.value){
        passwordCheck_result.innerText="확인 완료!"

    }else{
        passwordCheck_result.innerText="다시 입력!"
        passwordCheck.value.reset();
    }


})

btn.addEventListener("click",function(){
    if(username.value !="" && password.value !="" && passwordCheck.value !=""
        && name.value !="" && email.value !="" && date.value !="" &&  phone.value !=""
     ){
            console.log("회원 가입 성공")
           // btn.submit();

    }else{ console.log("회원 가입 실패")}

});

username.addEventListener("blur",()=>{

    console.log("입력됨")



})