function showLoader() {
    // Show loader
    document.getElementById("loader").style.display = "block";
}

function hideLoader() {
    // Hide loader
    document.getElementById("loader").style.display = "none";
}

async function loadNotesUploadPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapUploadNotes", true); // Servlet mapping
    xhr.send();
}

async function loadUserApprovalPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapApproveUser", true); // Servlet mapping
    xhr.send();
    await loadjsUserApprove();
}


async function loadPYQUploadPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapUploadPyq", true); // Servlet mapping
    xhr.send();
}

async function loadPlacementMaterialUploadPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapUploadPlacementMaterial", true); // Servlet mapping
    xhr.send();
}

async function loadIMPTopicsUploadPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapUploadImp", true); // Servlet mapping
    xhr.send();
}

async function loadNotesPyqApprovalPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapApproveNotesPyq", true); // Servlet mapping
    xhr.send();
}

async function loadDeleteApprovalPage() {
    showLoader(); // Show loader before making the API call
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState == 4 && xhr.status == 200) {
            document.getElementById("targetPageContainer").innerHTML = xhr.responseText;
            hideLoader(); // Hide loader after API call is completed
        }
    };
    xhr.open("GET", "mapApprovalDeleteUser", true); // Servlet mapping
    xhr.send();
}





