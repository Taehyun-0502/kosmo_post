
const replyup=document.getElementById("replyup")
const replydetail=document.getElementById("replydetail")
const review=document.getElementById("review_List")
const productNum=document.getElementById("num").innerText.trim()
const replydel= document.getElementById("replydel")
const update_btn=document.getElementById("update_btn")

getList()

function getList(){
    fetch("../reply/list?productNum="+productNum)
    .then(r=>r.text())
    .then(r=>{
        r=r.trim()
        review.innerHTML=r
    })
    
}
//업데이트
update_btn.addEventListener("click",()=>{
    let p = new FormData()
    let con =document.getElementById("content_update").value
    let repnum =review.getAttribute("data-reply-num")
    let n=document.getElementById("n1").innerText
    
    p.append("replyContents",con)
    p.append("replyStar",3)
    p.append("replyNum",n)
    
    fetch("/reply/update",{
        method:"POST",
        body:p
    }).then(r=>r.text())
    .then(r=>{
        r=r.trim()
        if(r>0){
            alert("수정 성공")
         getList()  
         con.innerText=""
          //document.getElementById("close").click();
        }else{
            alert("수정 실패")
        }
        $("#reviewModal").modal("hide");
    })
    
  



})









//삭제 버튼 
review.addEventListener("click",(e)=>{
   if(e.target.classList.contains("del")){
    let p= new FormData()
    p.append("productNum",productNum)
    let replynum= e.target.dataset.num
    p.append("replyNum",replynum)

    fetch("/reply/delete",{
        method:"POST",
        body:p
    }).then(r=>r.text())
    .then(r=>{
        r=r.trim()
        if(r>0){
            alert("삭제 성공")
        }else{}
        getList()

    })

   }
    if(e.target.classList.contains("update")){
        let replycon=e.target.parentElement.parentElement.firstElementChild.innerText
       let n=e.target.getAttribute("data-reply-num")
       
        document.getElementById("content_update").innerText=replycon
        document.getElementById("n1").innerText=n
        console.log(n)
        console.log(replycon)
        

    }


})




replyup.addEventListener("click",()=>{
    let p = new FormData();
    
    let reply=replydetail.value

    p.append("replyContents",reply)
    p.append("productNum",productNum)
    p.append("replyStar",4)
    
   fetch("/reply/create",{
    method:"POST",
    body:p

}).then(r=>r.text())
.then(r=>{
r=r.trim()
if(r>0){
    alert("등록성공")
} else{
    alert("등록실패")
}

replydetail.value=""
getList()
})
    
    console.log(reply);
  
})