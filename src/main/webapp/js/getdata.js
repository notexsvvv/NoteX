/**
 * 
 */     /*   fetch('UserAproval')
            .then(response => response.json())
            .then(data => {
                let userDataDiv = document.getElementById('userData');
                data.forEach(user => {
                    let userDiv = document.createElement('div');
                    userDiv.innerHTML = `
                        <p>Full Name: ${user.fullname}</p>
                        <p>Username: ${user.username}</p>
                        <p>Email: ${user.email}</p>
                        <p>LinkedIn: ${user.linkedin}</p>
                        <p>Mobile: ${user.mobile}</p>
                        <p>User Type: ${user.usertype}</p>
                        <p>Password: ${user.password}</p>
                        <p>Terms: ${user.terms}</p>
                        <img src="data:image/png;base64, ${user.collegeid}" alt="College ID Image">
                    `;
                    userDataDiv.appendChild(userDiv);
                });
            })
            .catch(error => console.error('Error fetching data:', error));

            */
            
            fetch('UserAproval', {
    method: 'POST',
    headers: {
        'Content-Type': 'application/x-www-form-urlencoded',
        // Add any additional headers if needed
    },
    body: 'token=ac62fd1d22a138f84e949d09c1334146', // Replace 'your_token_here' with the actual token
})
.then(response => {
    if (!response.ok) {
        throw new Error('Network response was not ok');
    }
    return response.json();
})
.then(data => {
     let userDataDiv = document.getElementById('userData');
                data.forEach(user => {
                    let userDiv = document.createElement('div');
                    userDiv.innerHTML = `
                        <p>Full Name: ${user.fullname}</p>
                        <p>Username: ${user.username}</p>
                        <p>Email: ${user.email}</p>
                        <p>LinkedIn: ${user.linkedin}</p>
                        <p>Mobile: ${user.mobile}</p>
                        <p>User Type: ${user.usertype}</p>
                        <p>Password: ${user.password}</p>
                        <p>Terms: ${user.terms}</p>
                        <img src="data:image/png;base64, ${user.collegeid}" alt="College ID Image">
                    `;
                    userDataDiv.appendChild(userDiv);
                });
    console.log(data); // Log the data to the console (you can replace this with your own logic)
})
.catch(error => {
    console.error('There was a problem with the fetch operation:', error);
});
            
            
            