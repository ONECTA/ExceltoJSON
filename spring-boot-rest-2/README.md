JQuery Code to test

var settings = {
  "url": "http://localhost:8080/parseExcel",
  "method": "POST",
  "timeout": 0,
  "headers": {
    "Content-Type": "application/x-www-form-urlencoded"
  },
  "data": {
    "param1": "value"
  }
};

$.ajax(settings).done(function (response) {
  console.log(response);
});

JAVASCRIPT 

var data = "SAMLResponse=abcdef";

var xhr = new XMLHttpRequest();
xhr.withCredentials = true;

xhr.addEventListener("readystatechange", function() {
  if(this.readyState === 4) {
    console.log(this.responseText);
  }
});

xhr.open("POST", "http://localhost:8080/parseExcel");
xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

xhr.send(data);


POST 

url :  http://localhost:8080/parseExcel
body:  Send any params 
{
    "Sheet1": [
        {
            "Emp": "A",
            "ID": 1.0,
            "Designation": "Developer"
        },
        {
            "Emp": "B",
            "ID": 2.0,
            "Designation": "BA"
        },
        {
            "Emp": "C",
            "ID": 3.0,
            "Designation": "PM"
        },
        {
            "Emp": "D",
            "ID": 4.0,
            "Designation": "Architect"
        }
    ]
}
