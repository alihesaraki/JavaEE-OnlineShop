<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fa">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>فرم پیام</title>
    <style>
        .error {
            color: red;
            font-size: 0.9em;
        }

        #errorList {
            color: red;
        }
    </style>
</head>
<body>
<div>
    <h2>خطاها:</h2>
    <ol id="errorList"></ol>
</div>
<h1>فرم پیام</h1>
<form id="messageForm" onsubmit="return sendMessage(event)">
    <div>
        <label for="title">عنوان:</label>
        <input type="text" id="title" name="title">
        <div class="error" id="titleError"></div>
    </div>
    <div>
        <label for="text">متن:</label>
        <textarea id="text" name="text"></textarea>
        <div class="error" id="textError"></div>
    </div>
    <button type="submit">ارسال پیام</button>
</form>


<script>
    function sendMessage(event) {
        event.preventDefault(); // Prevent the form from submitting

        // Clear previous errors
        document.getElementById('titleError').innerText = '';
        document.getElementById('textError').innerText = '';
        const errorList = document.getElementById('errorList');
        errorList.innerHTML = '';

        const title = document.getElementById('title').value;
        const text = document.getElementById('text').value;

        // Validate fields before sending
        let isValid = true;

        if (!title || title.trim() === '') {
            isValid = false;
            document.getElementById('titleError').innerText = 'عنوان نمی‌تواند خالی باشد.';
            const li = document.createElement('li');
            li.innerText = 'عنوان نمی‌تواند خالی باشد.';
            errorList.appendChild(li);
        }

        if (!text || text.trim() === '') {
            isValid = false;
            document.getElementById('textError').innerText = 'متن نمی‌تواند خالی باشد.';
            const li = document.createElement('li');
            li.innerText = 'متن نمی‌تواند خالی باشد.';
            errorList.appendChild(li);
        }

        if (isValid) {
            // If valid, send data to the server
            const messageData = {
                title: title,
                text: text
            };

            fetch('http://localhost/rest/messages', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(messageData)
            })
                .then(response => {
                    if (!response.ok) {
                        // Handle validation errors from the server
                        return response.json().then(err => {
                            handleErrors(err.errors);
                        });
                    }
                    // Optionally handle successful response
                    console.log('پیام با موفقیت ارسال شد!');
                    return response.json();
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }

        return isValid; // Return true if valid, false otherwise
    }

    function handleErrors(errors) {
        const errorList = document.getElementById('errorList');
        errorList.innerHTML = ''; // Clear previous errors

        for (const [field, message] of Object.entries(errors)) {
            // Display field-specific errors
            if (field === 'title') {
                document.getElementById('titleError').innerText = message;
            } else if (field === 'text') {
                document.getElementById('textError').innerText = message;
            }
            // Add to global error list
            const li = document.createElement('li');
            li.innerText = field + ":" +  message; // Display the field name and the message
            errorList.appendChild(li);
        }
    }
</script>
</body>
</html>
