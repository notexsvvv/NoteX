/**
 * 
 */        fetch('UserAproval')
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
