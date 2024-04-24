 function loadjsUserApprove() {
    fetchuserData();
    
};

function loadjsUserApprove() {
    showLoader(); // Show loader before fetching user data
    fetchuserData();
}

function showLoader() {
    document.getElementById("loader").classList.remove("hidden");
}

function hideLoader() {
    document.getElementById("loader").classList.add("hidden");
}

function getTokenFromCookie(cookieName) {
  var cookies = document.cookie.split(';');
  for (var i = 0; i < cookies.length; i++) {
    var cookie = cookies[i].trim();
    if (cookie.startsWith(cookieName + '=')) {
      return cookie.substring(cookieName.length + 1);
    }
  }
  return null;
}
let   fetchuserData = async () => {
			showLoader();
		  let token = getTokenFromCookie("token");
		  fetch('UserAproval', {
		    method: 'POST',
		    headers: {
		      'Content-Type': 'application/x-www-form-urlencoded',
		      // Add any additional headers if needed
		    },
		    body: 'token=' + token, // Replace 'your_token_here' with the actual token
		  })
		  .then(response => { 
		    if (!response.ok) {
		      throw new Error('Network response was not ok');
		    }
		    return response.json();
		  })
		  .then(data => {
				console.log(data);
				 if(data.length <1){
					
					 let userTable = document.getElementById("userTable");
						userTable.remove();
						let h4 = document.createElement("h4");
						h4.innerHTML=" No data Available in Table";
						document.getElementById("Userapproval").append(h4);
						alert(" No data Available in Table");
					
					return;
					
				}
				else{				
							    let userTable = document.getElementById("userTable").getElementsByTagName('tbody')[0];
							    userTable.innerHTML = ''; // Clear previous data
							
							    data.forEach(user => {
							      let row = userTable.insertRow();
							
							      let fullNameCell = row.insertCell(0);
							      fullNameCell.textContent = user.fullname;
							      fullNameCell.classList.add('full-name-cell'); // Add class for styling
							
							      let usernameCell = row.insertCell(1);
							      usernameCell.textContent = user.username;
							      usernameCell.classList.add('username-cell'); // Add class for styling
							
							      let emailCell = row.insertCell(2);
							      emailCell.textContent = user.email;
							      emailCell.classList.add('email-cell'); // Add class for styling
							
							     /* let linkedInCell = row.insertCell(3);
							      linkedInCell.textContent = user.linkedin;
							      linkedInCell.classList.add('linkedin-cell'); */// Add class for styling
							
							      let mobileCell = row.insertCell(3);
							      mobileCell.textContent = user.mobile;
							      mobileCell.classList.add('mobile-cell'); // Add class for styling
							
							      let userTypeCell = row.insertCell(4);
							      userTypeCell.textContent = user.usertype;
							      userTypeCell.classList.add('user-type-cell'); // Add class for styling
							
							      let termsCell = row.insertCell(5);
							      termsCell.textContent = user.terms;
							      termsCell.classList.add('terms-cell'); // Add class for styling
							
							      let collegeIDCell = row.insertCell(6);
							      let collegeIDImage = document.createElement("img");
							      collegeIDImage.src = "data:image/png;base64, " + user.collegeid;
							      collegeIDImage.alt = "College ID Image";
							      collegeIDImage.classList.add('college-id-image'); // Add class for styling
							      collegeIDCell.appendChild(collegeIDImage);
							      collegeIDCell.classList.add('college-id-cell'); // Add class for styling
							
							      let actionsCell = row.insertCell(7);
							      let approveButton = document.createElement("button");
							      approveButton.textContent = "Approve";
							      approveButton.classList.add('approve-button'); // Add class for styling
							      approveButton.addEventListener("click", () => {
							    acceptUser(user.username);
							});
							      actionsCell.appendChild(approveButton);
							      actionsCell.classList.add('actions-cell'); // Add class for styling
							
							      let rejectButton = document.createElement("button");
							      rejectButton.textContent = "Reject";
							      rejectButton.classList.add('reject-button'); // Add class for styling
							      rejectButton.addEventListener("click", () => {
							    rejectUser(user.username);
							});
							      actionsCell.appendChild(rejectButton);
							    });
					 }
		 hideLoader()
		  })
		  .catch(error => {
		    console.error('There was a problem with the fetch operation:', error);
		  });

}



function rejectUser(username) {
	if(confirm ("Do you want to reject user : "+username )==true){
		
	let token = getTokenFromCookie("token");
	showLoader();
  fetch('deleteUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      // Add any additional headers if needed
    },
    body: 'username=' + encodeURIComponent(username) + '&token=' + encodeURIComponent(token),
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {let res =(data.success);
  					if(res==true){
						alert(`User ${username} is rejected successfuly`);
						fetchuserData();
						fetchuserData();
						
					}
					else{
						alert(`User ${username} is cannot rejected Please Try again `);
					}
					
  	hideLoader()				
  					
  });
  
		
		
		}else {}
        
}

function acceptUser(username) {
    console.log("username  =- "+ username +" is accepted  ")
    
    if(confirm ("Do you want to acceptUser : "+username )==true){
		
	let token = getTokenFromCookie("token");
  fetch('acceptUser', {
    method: 'POST',
    headers: {
      'Content-Type': 'application/x-www-form-urlencoded',
      // Add any additional headers if needed
    },
    body: 'username=' + encodeURIComponent(username) + '&token=' + encodeURIComponent(token),
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    return response.json();
  })
  .then(data => {let res =(data.success);
  					if(res==true){
						alert(`User ${username} is accepted successfuly`);
						fetchuserData();
						fetchuserData();
						
					}
					else{
						alert(`User ${username} is cannot accept Please Try again `);
					}
					
  					
  					
  });
  
		
		
		}else {}
    
    
}