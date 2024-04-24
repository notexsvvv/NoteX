const btn = document.getElementById('btn');

btn.addEventListener('click', function handleClick() {
  var element = document.body;
  element.classList.toggle("dark-mode");

  const initialText = 'Dark Mode';

  if (btn.textContent.toLowerCase().includes(initialText.toLowerCase())) {
    btn.innerHTML =
      '<span >Light Mode</span>';
  } else {
    btn.textContent = initialText;
  }
});
document.getElementsByClassName("card-img-top");





function clearAllCookies() {
    var cookies = document.cookie.split(";");

    for (var i = 0; i < cookies.length; i++) {
        var cookie = cookies[i];
        var eqPos = cookie.indexOf("=");
        var name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
        document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
    }
}


window.onload = function() {
    clearAllCookies();
    /*alert("Cookies cleared!");*/
};

