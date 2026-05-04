
const replyup=document.getElementById("replyup")
const replydetail=document.getElementById("replydetail")
const review=document.getElementById("review_List")
const productNum=document.getElementById("num").innerText.trim()

getList()

function getList(){
    fetch("../reply/list?productNum="+productNum)
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        review.innerHTML=r
    })
    
}





// replyup.addEventListener("click",()=>{

//     let reply=replydetail.value
    

//    fetch("/reply/create",{
//     method:"POST",
//     body:

//    })
    
//     console.log(reply);

    
// })