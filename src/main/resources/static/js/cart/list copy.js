const all= document.getElementById("all")
const ch=document.querySelectorAll(".ch")
const debtn=document.getElementsByClassName("debtn")
const listAll= document.getElementsByClassName("listAll")
const checkdel= document.getElementById("checkdel")
//const checks=document.getElementsByClassName("ch")
const list = document.getElementById("list")

getList();

function getList(){
    fetch("./cartlist")
        .then(r=>r.text())
        .then(r=>{
            r.trim()
            list.innerHTML=r
        })    
    }


checkdel.addEventListener("click",()=>{
    let pn=new URLSearchParams;
    
    for(let c of ch){
        if(c.checked){
           pn.append("productNum",c.getAttribute("value"))

        }

    }
    
    fetch("./delete",{
        method:"POST",
        body: pn
    }).then(e=>e.text())
    .then(e=>{
        e=e.trim()
        if(e>0){
            for(let c of ch){
                if(c.checked){
                c.parentElement.parentElement.remove();
                }
            }

        }
    })



})



all.addEventListener("click",()=>{


    if(all.checked==true){

        for(let c of ch){
            c.checked=true;

        }

    }else if(all.checked==false){
        for(let c of ch){
            c.checked=false
        }

    }

})

for(let c of ch){
    c.addEventListener("click",()=>{
        let flag=true
        for(let d of ch){
        if(!d.checked){
            flag=false
        }
    }
    all.checked=flag

    })

}
for(let d of debtn){
    
d.addEventListener("click",()=>{
    let frm=new FormData();
   
    frm.append("productNum",d.value)

    fetch("./delete",{
        method:"POST",
        body:frm
        
    }).then(e=>e.text())
    .then(e=>{e.trim();

        if(e>0){
            d.parentElement.parentElement.remove();
            console.log("삭제 성공")
        }else{

        }


    })


    console.log("성공")

})}