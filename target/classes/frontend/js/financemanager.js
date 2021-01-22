/**
 * Finance Manager AJAX Page
 */


window.onload=function(){
	setUpPending();
	setUpHistory();
}

function setUpPending(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let rList = JSON.parse(xhttp.responseText);
			pendingRequests(rList);
		}
	}
	
	xhttp.open("GET", "http://localhost:9050/manager/pending");
	
	xhttp.send();
}

function pendingRequests(rList){
	
	let bottom = document.getElementById('p-final-line');
	let table = document.getElementById('pr-table');
	
	$.each(rList, function(index){
		let row = document.createElement("div");
		row.setAttribute("class", "row");
		let col1 = document.createElement("div");
		col1.setAttribute("class", "col-sm");
		let data1 = document.createTextNode(rList[index].amount);
		col1.appendChild(data1);
		row.appendChild(col1);
		
		let col2 = document.createElement("div");
		col2.setAttribute("class", "col-sm");
		let data2 = document.createTextNode(rList[index].description);
		col2.appendChild(data2);
		row.appendChild(col2);
		
		let col3 = document.createElement("div");
		col3.setAttribute("class", "col-sm");
		let data3 = document.createTextNode(rList[index].type);
		col3.appendChild(data3);
		row.appendChild(col3);
		
		let col4 = document.createElement("div");
		col4.setAttribute("class", "col-sm");
		let data4 = document.createTextNode(rList[index].submitted);
		col4.appendChild(data4);
		row.appendChild(col4);
		
		let col5 = document.createElement("div");
		col5.setAttribute("class", "col-sm");
		let data5 = document.createTextNode(rList[index].status);
		col5.appendChild(data5);
		row.appendChild(col5);
		
		let col6 = document.createElement("div");
		col6.setAttribute("class", "col-sm");
		let aForm = document.createElement("form");
		aForm.setAttribute("method", "post");
		aForm.setAttribute("action", "/resolve/approve/"+rList[index].rId);
		let aButton = document.createElement("input");
		aButton.setAttribute("type","submit");
		aButton.setAttribute("value","Approve");
		aForm.appendChild(aButton);
		col6.appendChild(aForm);
		row.appendChild(col6);
		
		let col7 = document.createElement("div");
		col7.setAttribute("class", "col-sm");
		let dForm = document.createElement("form");
		dForm.setAttribute("method", "post");
		dForm.setAttribute("action", "/resolve/deny/"+rList[index].rId);
		let dButton = document.createElement("input");
		dButton.setAttribute("type","submit");
		dButton.setAttribute("value","Deny");
		dForm.appendChild(dButton);
		col7.appendChild(dForm);
		row.appendChild(col7);
		
		table.insertBefore(row, bottom);
	});	
	
}

function setUpHistory(){
	let xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			let rrList = JSON.parse(xhttp.responseText);
			historyRequests(rrList);
		}
	}
	
	xhttp.open("GET", "http://localhost:9050/manager/history");
	
	xhttp.send();
}

function historyRequests(rrList){
	
	let bottom = document.getElementById('r-final-line');
	let table = document.getElementById('rr-table');
	
	$.each(rrList, function(index){
		let row = document.createElement("div");
		row.setAttribute("class", "row");
		let col1 = document.createElement("div");
		col1.setAttribute("class", "col-sm");
		let data1 = document.createTextNode(rrList[index].amount);
		col1.appendChild(data1);
		row.appendChild(col1);
		
		let col2 = document.createElement("div");
		col2.setAttribute("class", "col-sm");
		let data2 = document.createTextNode(rrList[index].description);
		col2.appendChild(data2);
		row.appendChild(col2);
		
		let col3 = document.createElement("div");
		col3.setAttribute("class", "col-sm");
		let data3 = document.createTextNode(rrList[index].type);
		col3.appendChild(data3);
		row.appendChild(col3);
		
		let col4 = document.createElement("div");
		col4.setAttribute("class", "col-sm");
		let data4 = document.createTextNode(rrList[index].submitted);
		col4.appendChild(data4);
		row.appendChild(col4);
		
		let col5 = document.createElement("div");
		col5.setAttribute("class", "col-sm");
		let data5 = document.createTextNode(rrList[index].resolved);
		col5.appendChild(data5);
		row.appendChild(col5);
		
		let col6 = document.createElement("div");
		col6.setAttribute("class", "col-sm");
		let data6 = document.createTextNode(rrList[index].status);
		col6.appendChild(data6);
		row.appendChild(col6);
		
		table.insertBefore(row, bottom);
	});	
	
}