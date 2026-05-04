const all= document.getElementById("all")

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
    let ch=document.querySelectorAll(".ch")
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
    let ch=document.querySelectorAll(".ch")

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



list.addEventListener("click", (e)=>{
    if(e.target.classList.contains("debtn")){
        let pn = e.target.previousElementSibling.getAttribute("value")
        let p = new URLSearchParams();
        p.append("productNum", pn);

        fetch("./delete", {
            method:"POST",
            body:p
        })
        .then(r=>r.text())
        .then(r=>{
            r = r.trim();
            if(r>0){
               getList();
            }else {
                alert('삭제 실패')
            }
        }) 
    }

    if(e.target.classList.contains("ch")){
        let chs = document.getElementsByClassName("ch")
        let r = true;
        for(let c of chs){
            if(!c.checked){
                r=false;
            }
        }
        all.checked=r;
    }
})
