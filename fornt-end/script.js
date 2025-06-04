document.addEventListener('DOMContentLoaded', function(){
    fetchData();
})


function submitForm() {
    var formData = {
        name: document.getElementById('name').value,
        email: document.getElementById('email').value,
        gender: document.getElementById('gender').value,
        phone: document.getElementById('phone').value
    };

    fetch('http://localhost:8080/api/form-data', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(formData)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Success:', data);
        alert('Form submitted successfully!');
        fetchData();
    })
    .catch((error) => {
        console.error('Error:', error);
        alert('Error submitting form');
    });
}

function fetchData(){
    fetch('http://localhost:8080/api/read-form-data')
    .then(response => response.json())
    .then(data => buildTable(data))
    .catch(error => console.error('Error:', error));
}

function buildTable(data) {
    var table = `<table>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Gender</th>
                        <th>Phone</th>
                        <th>Action</th>
                    </tr>`;

    data.forEach(item=> {
        table += `<tr key=${item.id}>
                    <td>${item.name}</td>
                    <td>${item.email}</td>
                    <td>${item.gender}</td>
                    <td>${item.phone}</td>
                    <td><button onclick="deleteRow(${item.id})" class="delete-button">Delete</button></td>
                  </tr>`;
    });

    table += `</table>`;
    document.getElementById('table-container').innerHTML = table;
}

function deleteRow(id) {
    fetch(`http://localhost:8080/api/form-data/${id}`, {
        method: 'DELETE'
    })
    .then(response => {
        if (response.ok) {
            console.log('Item deleted successfully');
            fetchData(); 
        } else {
            throw new Error('Item could not be deleted');
        }
    })
    .catch(error => console.error('Error:', error));
}












