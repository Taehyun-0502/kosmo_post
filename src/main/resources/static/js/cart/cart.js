const cart=document.getElementById("cart")
const num=document.getElementById("num")
cart.addEventListener("click",()=>{
	
	let number=num.innerText
	
	console.log(number)
	let params=new URLSearchParams();
	params.append("productNum",number)
	
	
	fetch(`../cart/create`,{
		method:"POST",
		body:params
	}).then(r=>r.text())
	.then(r=> {
		r=r.trim();
		if(r>0){
			let flag=confirm("장바구니로 이동?")
			if(flag){
			//나중에 이부분 보내기 해야함
					location.href="http://localhost/cart/list"
				
			}else{}	
			
			
		} else{
			alert("장바구니에 담기를 실패했습니다")
		}
		
	})
	//등록 성공이면 장바구니로 이동?
	
	
	
	
	
	
	
})