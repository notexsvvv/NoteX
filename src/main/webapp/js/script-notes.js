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






let mainDiv = document.getElementsByClassName("main-n");
let formDiv = document.getElementsByClassName("form-n")[0];
console.log(mainDiv);
console.log(formDiv)
const removeform = () => {
  formDiv.firstElementChild.innerHTML = `

  <div class="container-n" >
     <div class="ag-format-container">
       <div class="ag-courses_box">
         <div class="ag-courses_item">
           <div  class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card1">
               UI/Web&amp;Graph design for teenagers 11-17&#160;years old
             </div>

             <div class="ag-courses-item_date-box">
                <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
               
             </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div  class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card2">
               UX/UI Web-Design&#160;+ Mobile Design
             </div>

             <div class="ag-courses-item_date-box">
              <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
             </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div  class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card3">
               Annual package "Product+UX/UI+Graph designer&#160;2022"
             </div>

             <div class="ag-courses-item_date-box">
              <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
             </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div  class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card4">
               Graphic Design
             </div>

             <div class="ag-courses-item_date-box">
               <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
             </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div  class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card5">
               Motion Design
             </div>

             <div class="ag-courses-item_date-box">
             <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
             </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card6">
               Front-end development&#160;+ jQuery&#160;+ CMS
             </div>
             <div class="ag-courses-item_date-box">
              <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
              </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div class="ag-courses-item_link">
             <div class="ag-courses-item_bg">
             </div>
             <div class="ag-courses-item_title card7">
               Digital Marketing
             </div>
             <div class="ag-courses-item_date-box">
               <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
              </div>
           </div>
         </div>

         <div class="ag-courses_item">
           <div class="ag-courses-item_link">
             <div class="ag-courses-item_bg"></div>

             <div class="ag-courses-item_title card8">
               Interior Design
             </div>

             <div class="ag-courses-item_date-box">
              <ul list-style-type: none>
                   <a href="#"  class ="unit1">  <li> Unit  1 </li><br><li> </li></a>
                   
                   <a href="#" class ="unit2">  <li> Unit  2 </li> <br><li> </li </a>
                   <a href="#" class ="unit3">  <li> Unit  3 </li><br> <li> </li </a>
                   <a href="#" class ="unit4">  <li> Unit  4 </li> <br> <li> </li</a>
                   <a href="#" class ="unit5">  <li> Unit  5 </li><br> <li> </li </a>
                  </ul>
               <a href="#" class="allunit"> <span> Download all units </span></a>
             </div>
           </div>
         </div>

       </div>
     </div>
    </div>  
`


}
function data(subjectname) {
  let cardscount = document.getElementsByClassName("ag-courses-item_title");
  //console.log(subtitle);
  for (let i = 0; i < subjectname.length; i++) {
    document.getElementsByClassName("ag-courses-item_title")[i].firstChild.textContent = subjectname[i];

  }
  for (let i = subjectname.length; i < cardscount.length; i++) {
    document.getElementsByClassName("ag-courses-item_title")[i].parentNode.style.display = "none";
  }

}

function getData() {

  let branch = document.getElementById("branch").value;
  let sem = document.getElementById("sem").value;
  console.log(branch)
  console.log(sem)

  if (branch === "Computer Science") {

    // removeform();

    if (sem === "cs-I Semester") {

      let subjectname = [
        "Mathematics-1",
        "Applied Physics",
        "Digital Logic and Circuit Design",
        "Introduction to Computer Science and Engineering",
        "Principal of C Language",
        "Computer System Organisation",
        "WDL-1"]
      removeform(); data(subjectname);
    }
    else if (sem === "cs-II Semester") {
      let subjectname = [
        "Mathematics-2",
        "Communication Skills",
        "Data Structure and Algorithms",
        "Object Oriented Programming",
        "Data Communication",
        "Priciple of Programming Language",
        "Operating System"
      ]
      removeform(); data(subjectname)
    }
    else if (sem === "cs-III Semester") {
      let subjectname = [
        " Discrete Structure",
        "Analysis and Design of Algorithm",
        "Computer Graphics and Multimedia",
        "Computer Network",
        "Essential of E-Commerce",
        "WDL-2 (PHP)",
        "Core Java (lab)"
      ]
      removeform(); data(subjectname)
    }
    else if (sem === "cs-IV Semester") {
      let subjectname =["Software Engineering and Project Management","Database Management System","Fundamentals Of Design Thinking","Information Storage Management", "Environmental Management and Sustainability","Advance Java Lab", "Unix Programming Lab"];
      removeform(); data(subjectname)
    }
    else {
      alert("Provde Valid Branch and Semester");
    }
  }
  else if (branch === "Computer Science" && sem === "Select") {
    alert("Provde Valid Branch and Semester");
  }
  else {
    alert("Provde Valid Branch and Semester");
  }

}





let subtitle = document.getElementsByClassName("ag-courses-item_title")[0];
console.log(subtitle)
