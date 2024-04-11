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



let span =document.getElementsByClassName("col-6")[0];
//span.style.color="red";
span.textContent="vivek patel";


