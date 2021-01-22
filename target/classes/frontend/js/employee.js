/**
 * Employee AJAX file
 */

window.onload=function(){
	getUserSession();
}

function getUserSession(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let user = JSON.parse(xhttp.responseText);
			userDOMManip(user);
		}
	}
	
	xhttp.open("GET", "http://localhost:9050/session");
	
	xhttp.send();
}

function userDOMManip(userJSON){
	
	let bottom = document.getElementById('final-line');
	let table = document.getElementById('r-table')
	
	$.each(userJSON, function(index){
		let row = document.createElement("div");
		row.setAttribute("class", "row");
		let col1 = document.createElement("div");
		col1.setAttribute("class", "col-sm");
		let data1 = document.createTextNode(userJSON[index].amount);
		col1.appendChild(data1);
		row.appendChild(col1);
		
		let col2 = document.createElement("div");
		col2.setAttribute("class", "col-sm");
		let data2 = document.createTextNode(userJSON[index].description);
		col2.appendChild(data2);
		row.appendChild(col2);
		
		let col3 = document.createElement("div");
		col3.setAttribute("class", "col-sm");
		let data3 = document.createTextNode(userJSON[index].type);
		col3.appendChild(data3);
		row.appendChild(col3);
		
		let col4 = document.createElement("div");
		col4.setAttribute("class", "col-sm");
		let data4 = document.createTextNode(userJSON[index].status);
		col4.appendChild(data4);
		row.appendChild(col4);
		
		let col5 = document.createElement("div");
		col5.setAttribute("class", "col-sm");
		let data5 = document.createTextNode(userJSON[index].submitted);
		col5.appendChild(data5);
		row.appendChild(col5);
		
		let col6 = document.createElement("div");
		col6.setAttribute("class", "col-sm");
		let data6 = document.createTextNode(userJSON[index].resolved);
		col6.appendChild(data6);
		row.appendChild(col6);
		
		table.insertBefore(row, bottom);
	});	
	
}