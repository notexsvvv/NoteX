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

let fetchuserData = () => {
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
  })
  .catch(error => {
    console.error('There was a problem with the fetch operation:', error);
  });

}

document.addEventListener("DOMContentLoaded", function() {
  // Get all buttons
  var buttons = document.querySelectorAll(".nav-link");

  // Get all divs
  var divs = document.querySelectorAll(".main-div, .Upload-notes-div, .Upload-pyq-div, .Upload-placementmaterial-div, .Upload-imptopics-div, .Userapproval-div, .Notes-pyqapproval-div, .Delete-approval-div");

  // Hide all divs
  function hideAllDivs() {
    divs.forEach(function(div) {
      div.style.display = "none";
    });
  }

  // Show div corresponding to clicked button
  function showDiv(divClass) {
    hideAllDivs();
    document.querySelector("." + divClass).style.display = "block";
  }

  // Add click event listener to each button
  buttons.forEach(function(button) {
    button.addEventListener("click", function(event) {
      event.preventDefault();

      // Hide all divs
      hideAllDivs();

      // Determine which div to show based on button clicked
      if (button.textContent === "Notes" || button.textContent === "Upload") {
        showDiv("main-div");
      } else if (button.textContent === "User Approval") {
        fetchuserData(); // Call fetchuserData function
        showDiv("Userapproval-div");
      } else if (button.textContent === "Notes/Pyq Approval") {
        showDiv("Notes-pyqapproval-div");
      } else if (button.textContent === "Delete Approval") {
        showDiv("Delete-approval-div");
      }
    });
  });

  // Add click event listener to each dropdown item
  var dropdownItems = document.querySelectorAll(".dropdown-item");
  dropdownItems.forEach(function(item) {
    item.addEventListener("click", function(event) {
      event.preventDefault();

      // Hide all divs
      hideAllDivs();

      var listItemText = item.textContent.trim();
      // Show the corresponding div based on the clicked list item
      if (listItemText === "Notes") {
        showDiv("Upload-notes-div");
      } else if (listItemText === "PYQ") {
        showDiv("Upload-pyq-div");
      } else if (listItemText === "Placement Material") {
        showDiv("Upload-placementmaterial-div");
      } else if (listItemText === "Important Topics") {
        showDiv("Upload-imptopics-div");
      }
    });
  });

  // Initially, show the main div
  showDiv("main-div");
});



function rejectUser(username) {
	if(confirm ("Do you want to reject ="+username )==true){
		
		
		 {
        if (xhr.status >= 200 && xhr.status < 300) {
            // Request was successful
            var response = JSON.parse(xhr.responseText);
            if (response.success) {
                // User deleted successfully
                console.log('User deleted successfully');
            } else {
                // Error deleting user
                console.error('Error deleting user:', response.error);
            }
        } else {
            // Request failed
            console.error('Request failed with status:', xhr.status);
        }
    };

    // Define the callback function to handle errors
    xhr.onerror = function() {
        console.error('Request failed');
    };

    // Send the request
    xhr.send();
		
		
	}
	else{
		
	}
    console.log("username  =- "+ username +" is rejected ")
}

function acceptUser(username) {
    console.log("username  =- "+ username +" is accepted  ")
}