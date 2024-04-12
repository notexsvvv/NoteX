// JavaScript for button clicks
document.addEventListener("DOMContentLoaded", function() {

  // Get all buttons
  var buttons = document.querySelectorAll(".nav-link");
  var buttons2 = document.querySelectorAll(".nav-link");
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
      if (button.textContent === "Notes") {
        showDiv("main-div");
      } else if (button.textContent === "User Approval") {
        showDiv("Userapproval-div");
      } else if (button.textContent === "Notes/Pyq Approval") {
        showDiv("Notes-pyqapproval-div");
      } else if (button.textContent === "Delete Approval") {
        showDiv("Delete-approval-div");
      } else if (button.textContent === "Upload") {
        // For the "Upload" button, check which list item is clicked and show the corresponding div
        var listItem = event.target.closest(".dropdown-item");
        if (listItem) {
          var listItemText = listItem.textContent.trim();
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
        }
      }
    });
  });

  // Initially, show the main div
  showDiv("main-div");
});
