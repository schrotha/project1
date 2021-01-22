/*
window.onload = function(){
	console.log("in ajax");
	document.getElementById('login-form').addEventListener('submit', loginCheck);
}

function loginCheck(){
	console.log("in login check dddddddddddddddddddddddddddddddddddddddddddddddddddddddd")
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		
		if(xhttp.readyState == 4 && xhttp.status == 401){
			document.getElementById('error-message').innerText = "Username and Password combination not found, please try again";
		}
		
		if(xhttp.readyState == 4 && xhttp.status == 200){
			
		}
		
	}
	
	xhttp.open("POST", "/login");
	
	xhttp.send();
}
*/