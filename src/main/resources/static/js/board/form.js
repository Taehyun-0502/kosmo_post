const btn1=document.getElementById("add")
const result=document.getElementById("result")
const create=document.getElementById("create")

// create.addEventListener("click",()=>{
//     let form = new FormData();

//     form.append("boardTitle","ajax title");
    
//     form.append("boardContents","ajax contents")
//     form.append("boardWriter","ajax writer")
//     fetch("./create",{
//         method:"POST",
//         body:form
//     }).then(res=>res.text())
//     .then(res=>console.log(res))

// })



let idx=1

let count=0
btn1.addEventListener("click",function(){

    if(count>4){
        alert("최대 5개만 가능합니다")
        return
    }
    let i = document.createElement("input");
    let d= document.createElement("div")
    i.classList.add("form-control");
    i.type="file"
    i.name="attach"
    d.id=`${idx}`
    d.append(i)
    
    let b= document.createElement("button")
    b.innerText="delete"
    b.setAttribute("data-id",`${idx}`)
    b.type="button"
    b.classList.add("delete")
    
    d.append(b)
    result.append(d);
    
    idx++
    count++

})

result.addEventListener("click",function(e){

    if(e.target.classList.contains("delete")){

        let di = e.target.getAttribute("data-id")
        document.getElementById(di).remove()
        count--
    }


})


