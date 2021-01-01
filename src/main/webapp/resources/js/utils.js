function getCookie(name) {
    // Split cookie string and get all individual name=value pairs in an array
    var cookieArr = document.cookie.split(";");

    // Loop through the array elements
    for (var i = 0; i < cookieArr.length; i++) {
        var cookiePair = cookieArr[i].split("=");

        if (name == cookiePair[0].trim()) {
            return decodeURIComponent(cookiePair[1]);
        }
    }
}

function clearCookies() { 
    var allCookies = document.cookie.split(';'); 
   
    // The "expire" attribute of every cookie is  
    // Set to "Thu, 01 Jan 1970 00:00:00 GMT" 
    for (var i = 0; i < allCookies.length; i++) 
        document.cookie = allCookies[i] + "=;expires=" 
        + new Date(0).toUTCString(); 
    displayCookies.innerHTML = document.cookie; 
} 

